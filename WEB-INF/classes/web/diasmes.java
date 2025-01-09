package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diasmes extends GXProcedure
{
   public diasmes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diasmes.class ), "" );
   }

   public diasmes( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            java.util.Date aP1 )
   {
      diasmes.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             short[] aP2 )
   {
      diasmes.this.AV9CliCod = aP0;
      diasmes.this.AV11Fecha = aP1;
      diasmes.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8meses30Dias = GXutil.boolval( new web.getparametro(remoteHandle, context).executeUdp( AV9CliCod, new web.meses30dias_codigoparam(remoteHandle, context).executeUdp( ))) ;
      if ( AV8meses30Dias )
      {
         AV10Cantidad = (short)(30) ;
      }
      else
      {
         AV12FechaAux = GXutil.eomdate( AV11Fecha) ;
         AV10Cantidad = (short)(GXutil.day( AV12FechaAux)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = diasmes.this.AV10Cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12FechaAux = GXutil.nullDate() ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10Cantidad ;
   private short Gx_err ;
   private int AV9CliCod ;
   private java.util.Date AV11Fecha ;
   private java.util.Date AV12FechaAux ;
   private boolean AV8meses30Dias ;
   private short[] aP2 ;
}

