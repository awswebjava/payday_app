package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class caldependenciaresuelta extends GXProcedure
{
   public caldependenciaresuelta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( caldependenciaresuelta.class ), "" );
   }

   public caldependenciaresuelta( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( byte aP0 )
   {
      caldependenciaresuelta.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( byte aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( byte aP0 ,
                             byte[] aP1 )
   {
      caldependenciaresuelta.this.AV8LiqDCalculado = aP0;
      caldependenciaresuelta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8LiqDCalculado == 0 )
      {
         AV9Calculado = (byte)(0) ;
      }
      else
      {
         AV9Calculado = (byte)(1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = caldependenciaresuelta.this.AV9Calculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV9Calculado ;
   private short Gx_err ;
   private byte[] aP1 ;
}

