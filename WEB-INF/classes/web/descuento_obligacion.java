package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuento_obligacion extends GXProcedure
{
   public descuento_obligacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuento_obligacion.class ), "" );
   }

   public descuento_obligacion( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             byte[] aP11 )
   {
      descuento_obligacion.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        byte[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 )
   {
      descuento_obligacion.this.AV20CliCod = aP0;
      descuento_obligacion.this.AV23EmpCod = aP1;
      descuento_obligacion.this.AV30liqnro = aP2;
      descuento_obligacion.this.AV28LegNumero = aP3;
      descuento_obligacion.this.AV31LiqPeriodo = aP4;
      descuento_obligacion.this.AV21ConCodigo = aP5;
      descuento_obligacion.this.AV47TipoOblCodigo = aP6;
      descuento_obligacion.this.AV42ProcesoLiquidacion = aP7;
      descuento_obligacion.this.AV41insertandoConceptos = aP8;
      descuento_obligacion.this.aP9 = aP9;
      descuento_obligacion.this.aP10 = aP10;
      descuento_obligacion.this.aP11 = aP11;
      descuento_obligacion.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV29LiqDCalculado = (byte)(1) ;
      GXt_int1 = AV46PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV20CliCod, GXv_int2) ;
      descuento_obligacion.this.GXt_int1 = GXv_int2[0] ;
      AV46PaiCod = GXt_int1 ;
      GXv_int2[0] = AV52TipoOblSec ;
      GXv_boolean3[0] = AV44TipoOblAnti ;
      GXv_int4[0] = AV48TipoOblTotTipo ;
      GXv_int5[0] = AV59EmbargaSec ;
      GXv_char6[0] = AV54tipoOblError ;
      GXv_int7[0] = AV53tipoOblLiqDCalculado ;
      new web.gettipooblsecporcodigo(remoteHandle, context).execute( AV46PaiCod, AV47TipoOblCodigo, GXv_int2, GXv_boolean3, GXv_int4, GXv_int5, GXv_char6, GXv_int7) ;
      descuento_obligacion.this.AV52TipoOblSec = GXv_int2[0] ;
      descuento_obligacion.this.AV44TipoOblAnti = GXv_boolean3[0] ;
      descuento_obligacion.this.AV48TipoOblTotTipo = GXv_int4[0] ;
      descuento_obligacion.this.AV59EmbargaSec = GXv_int5[0] ;
      descuento_obligacion.this.AV54tipoOblError = GXv_char6[0] ;
      descuento_obligacion.this.AV53tipoOblLiqDCalculado = GXv_int7[0] ;
      if ( AV53tipoOblLiqDCalculado == 0 )
      {
         AV29LiqDCalculado = (byte)(0) ;
         AV8error = GXutil.trim( AV54tipoOblError) ;
         AV9LiqDLog = AV8error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_decimal8[0] = AV49cuota_LiqDImpCalcu ;
      GXv_char6[0] = AV50cuota_LiqDLog ;
      GXv_char9[0] = AV56cuotaError ;
      GXv_int7[0] = AV57cuota_LiqDCalculado ;
      new web.cuota_obligacion_v2(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV30liqnro, AV28LegNumero, AV52TipoOblSec, AV31LiqPeriodo, AV21ConCodigo, AV46PaiCod, AV42ProcesoLiquidacion, AV41insertandoConceptos, GXv_decimal8, GXv_char6, GXv_char9, GXv_int7) ;
      descuento_obligacion.this.AV49cuota_LiqDImpCalcu = GXv_decimal8[0] ;
      descuento_obligacion.this.AV50cuota_LiqDLog = GXv_char6[0] ;
      descuento_obligacion.this.AV56cuotaError = GXv_char9[0] ;
      descuento_obligacion.this.AV57cuota_LiqDCalculado = GXv_int7[0] ;
      if ( AV57cuota_LiqDCalculado == 0 )
      {
         AV29LiqDCalculado = (byte)(0) ;
         AV8error = AV56cuotaError ;
         AV9LiqDLog += AV8error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV9LiqDLog = AV50cuota_LiqDLog ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = descuento_obligacion.this.AV49cuota_LiqDImpCalcu;
      this.aP10[0] = descuento_obligacion.this.AV8error;
      this.aP11[0] = descuento_obligacion.this.AV29LiqDCalculado;
      this.aP12[0] = descuento_obligacion.this.AV9LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV49cuota_LiqDImpCalcu = DecimalUtil.ZERO ;
      AV8error = "" ;
      AV9LiqDLog = "" ;
      GXv_int2 = new short[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new short[1] ;
      AV54tipoOblError = "" ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV50cuota_LiqDLog = "" ;
      GXv_char6 = new String[1] ;
      AV56cuotaError = "" ;
      GXv_char9 = new String[1] ;
      GXv_int7 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV29LiqDCalculado ;
   private byte AV48TipoOblTotTipo ;
   private byte GXv_int4[] ;
   private byte AV53tipoOblLiqDCalculado ;
   private byte AV57cuota_LiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV23EmpCod ;
   private short AV46PaiCod ;
   private short GXt_int1 ;
   private short AV52TipoOblSec ;
   private short GXv_int2[] ;
   private short AV59EmbargaSec ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV30liqnro ;
   private int AV28LegNumero ;
   private java.math.BigDecimal AV49cuota_LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV21ConCodigo ;
   private String AV47TipoOblCodigo ;
   private String AV42ProcesoLiquidacion ;
   private String GXv_char6[] ;
   private String GXv_char9[] ;
   private java.util.Date AV31LiqPeriodo ;
   private boolean AV41insertandoConceptos ;
   private boolean AV44TipoOblAnti ;
   private boolean GXv_boolean3[] ;
   private boolean returnInSub ;
   private String AV9LiqDLog ;
   private String AV50cuota_LiqDLog ;
   private String AV8error ;
   private String AV54tipoOblError ;
   private String AV56cuotaError ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private byte[] aP11 ;
}

