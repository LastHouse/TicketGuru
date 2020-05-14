import React, { useState } from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import Tooltip from '@material-ui/core/Tooltip';
import { useAuthContext } from '../utils/AuthContext';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import CssBaseline from '@material-ui/core/CssBaseline';

import moment from 'moment/moment.js';
import 'moment-timezone';

export default function SaleRows(props) {
  const { auth } = useAuthContext();
  const [open, setOpen] = useState(false);
  const [saleRowTickets, setSaleRowTickets] = useState([]);

  const handleClickOpen = () => {
    setOpen(true);
    fetchSaleRow();
  };

  const handleClose = () => {
    setOpen(false);
  };

  const fetchSaleRow = () => {
    fetch(props.saleRow._links.tickets.href, {
      headers: {
        Authorization: `Bearer ${auth.token}`,
      },
    })
      .then((response) => response.json())
      .then((data) => setSaleRowTickets(data._embedded.tickets))
      .catch((err) => console.error(err));
  };

  return (
    <div>
      <CssBaseline />
      <Tooltip title="Tickets">
        <Button
          variant="outlined"
          color="secondary"
          onClick={() => handleClickOpen()}
          size="small"
        >
          Tickets from Sale Event
        </Button>
      </Tooltip>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">Sale Rows</DialogTitle>

        <DialogContent>
          <List>
            {saleRowTickets.map((item, i) => (
              <ListItem key={i}>
                <ListItemText>
                  {i + 1}. Created:
                  {moment(item.created).format('DD/MM/YYYY HH:mm')} <br></br>
                </ListItemText>
                <ListItemText> Ticket Checksum: {item.checksum}</ListItemText>
              </ListItem>
            ))}
          </List>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Exit
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
