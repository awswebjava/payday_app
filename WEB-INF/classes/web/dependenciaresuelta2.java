package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dependenciaresuelta2 extends GXProcedure
{
   public dependenciaresuelta2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dependenciaresuelta2.class ), "" );
   }

   public dependenciaresuelta2( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           String aP2 ,
                           byte aP3 ,
                           short aP4 )
   {
      dependenciaresuelta2.this.aP5 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        short aP4 ,
                        byte[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             byte[] aP5 )
   {
      dependenciaresuelta2.this.AV14CliCod = aP0;
      dependenciaresuelta2.this.AV13ConCodigo = aP1;
      dependenciaresuelta2.this.AV9ProcesoLiquidacion = aP2;
      dependenciaresuelta2.this.AV11LiqDCalculado = aP3;
      dependenciaresuelta2.this.AV12LiqDRecalculado = aP4;
      dependenciaresuelta2.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV8ConRecalcular ;
      new web.conceptorecalcula(remoteHandle, context).execute( AV14CliCod, AV13ConCodigo, GXv_boolean1) ;
      dependenciaresuelta2.this.AV8ConRecalcular = GXv_boolean1[0] ;
      if ( ! AV8ConRecalcular || ( GXutil.strcmp(AV9ProcesoLiquidacion, "Calculo") == 0 ) )
      {
         GXv_int2[0] = AV10Calculado ;
         new web.caldependenciaresuelta(remoteHandle, context).execute( AV11LiqDCalculado, GXv_int2) ;
         dependenciaresuelta2.this.AV10Calculado = GXv_int2[0] ;
      }
      else
      {
         GXv_int2[0] = AV10Calculado ;
         new web.recalgandependenciaresuelta(remoteHandle, context).execute( AV12LiqDRecalculado, GXv_int2) ;
         dependenciaresuelta2.this.AV10Calculado = GXv_int2[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = dependenciaresuelta2.this.AV10Calculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean1 = new boolean[1] ;
      GXv_int2 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11LiqDCalculado ;
   private byte AV10Calculado ;
   private byte GXv_int2[] ;
   private short AV12LiqDRecalculado ;
   private short Gx_err ;
   private int AV14CliCod ;
   private String AV13ConCodigo ;
   private String AV9ProcesoLiquidacion ;
   private boolean AV8ConRecalcular ;
   private boolean GXv_boolean1[] ;
   private byte[] aP5 ;
}

