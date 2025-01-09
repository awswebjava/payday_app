package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisargentina extends GXProcedure
{
   public paisargentina( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisargentina.class ), "" );
   }

   public paisargentina( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      paisargentina.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      paisargentina.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8PaiCod = (short)(12) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = paisargentina.this.AV8PaiCod;
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

   private short AV8PaiCod ;
   private short Gx_err ;
   private short[] aP0 ;
}

