package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armamespalabra extends GXProcedure
{
   public armamespalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armamespalabra.class ), "" );
   }

   public armamespalabra( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.util.Date aP1 )
   {
      armamespalabra.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             String[] aP2 )
   {
      armamespalabra.this.AV11CliCod = aP0;
      armamespalabra.this.AV8LiqPeriodo = aP1;
      armamespalabra.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Mes = (byte)(GXutil.month( AV8LiqPeriodo)) ;
      AV10mesPalabra = GXutil.upper( httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)AV9Mes), "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = armamespalabra.this.AV10mesPalabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10mesPalabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9Mes ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10mesPalabra ;
   private java.util.Date AV8LiqPeriodo ;
   private String[] aP2 ;
}

