package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethorasdianormal extends GXProcedure
{
   public gethorasdianormal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethorasdianormal.class ), "" );
   }

   public gethorasdianormal( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      gethorasdianormal.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      gethorasdianormal.this.AV13CliCod = aP0;
      gethorasdianormal.this.AV15EmpCod = aP1;
      gethorasdianormal.this.AV14LegNumero = aP2;
      gethorasdianormal.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV8PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV13CliCod, GXv_int1) ;
      gethorasdianormal.this.AV8PaiCod = GXv_int1[0] ;
      if ( (0==AV14LegNumero) )
      {
         GXv_decimal2[0] = AV11horasDiaNormal ;
         new web.getpaidiahornormales(remoteHandle, context).execute( AV8PaiCod, "diurno", GXv_decimal2) ;
         gethorasdianormal.this.AV11horasDiaNormal = GXv_decimal2[0] ;
      }
      else
      {
         GXv_char3[0] = AV9ConveCodigo ;
         new web.empleadogetconvenio(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, GXv_char3) ;
         gethorasdianormal.this.AV9ConveCodigo = GXv_char3[0] ;
         GXv_boolean4[0] = AV16diurnoEs ;
         GXv_char3[0] = AV19diurnoLegTipoTra ;
         GXv_boolean5[0] = AV20nocturnoEs ;
         GXv_char6[0] = AV21nocturnoLegTipoTra ;
         GXv_boolean7[0] = AV22insalubreEs ;
         GXv_char8[0] = AV23insalubreLegTipoTra ;
         new web.empleadogettipotra(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, AV18LegTipoTra, GXv_boolean4, GXv_char3, GXv_boolean5, GXv_char6, GXv_boolean7, GXv_char8) ;
         gethorasdianormal.this.AV16diurnoEs = GXv_boolean4[0] ;
         gethorasdianormal.this.AV19diurnoLegTipoTra = GXv_char3[0] ;
         gethorasdianormal.this.AV20nocturnoEs = GXv_boolean5[0] ;
         gethorasdianormal.this.AV21nocturnoLegTipoTra = GXv_char6[0] ;
         gethorasdianormal.this.AV22insalubreEs = GXv_boolean7[0] ;
         gethorasdianormal.this.AV23insalubreLegTipoTra = GXv_char8[0] ;
         GXv_char8[0] = AV17PaiTipoTraId ;
         new web.decidirtipodetrabajo(remoteHandle, context).execute( AV16diurnoEs, AV20nocturnoEs, AV22insalubreEs, AV19diurnoLegTipoTra, AV21nocturnoLegTipoTra, AV23insalubreLegTipoTra, GXv_char8) ;
         gethorasdianormal.this.AV17PaiTipoTraId = GXv_char8[0] ;
         if ( ! (GXutil.strcmp("", AV9ConveCodigo)==0) )
         {
            GXv_decimal2[0] = AV11horasDiaNormal ;
            new web.getconvediahoras(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, AV8PaiCod, AV9ConveCodigo, AV17PaiTipoTraId, GXv_decimal2) ;
            gethorasdianormal.this.AV11horasDiaNormal = GXv_decimal2[0] ;
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11horasDiaNormal)==0) )
         {
            GXv_decimal2[0] = AV11horasDiaNormal ;
            new web.getempdiahoras(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV17PaiTipoTraId, GXv_decimal2) ;
            gethorasdianormal.this.AV11horasDiaNormal = GXv_decimal2[0] ;
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11horasDiaNormal)==0) )
         {
            GXv_decimal2[0] = AV11horasDiaNormal ;
            new web.getpaidiahornormales(remoteHandle, context).execute( AV8PaiCod, AV17PaiTipoTraId, GXv_decimal2) ;
            gethorasdianormal.this.AV11horasDiaNormal = GXv_decimal2[0] ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gethorasdianormal.this.AV11horasDiaNormal;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11horasDiaNormal = DecimalUtil.ZERO ;
      GXv_int1 = new short[1] ;
      AV9ConveCodigo = "" ;
      AV18LegTipoTra = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean4 = new boolean[1] ;
      AV19diurnoLegTipoTra = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV21nocturnoLegTipoTra = "" ;
      GXv_char6 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV23insalubreLegTipoTra = "" ;
      AV17PaiTipoTraId = "" ;
      GXv_char8 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV8PaiCod ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV11horasDiaNormal ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV9ConveCodigo ;
   private String AV19diurnoLegTipoTra ;
   private String GXv_char3[] ;
   private String AV21nocturnoLegTipoTra ;
   private String GXv_char6[] ;
   private String AV23insalubreLegTipoTra ;
   private String AV17PaiTipoTraId ;
   private String GXv_char8[] ;
   private boolean AV16diurnoEs ;
   private boolean GXv_boolean4[] ;
   private boolean AV20nocturnoEs ;
   private boolean GXv_boolean5[] ;
   private boolean AV22insalubreEs ;
   private boolean GXv_boolean7[] ;
   private java.math.BigDecimal[] aP3 ;
   private GXSimpleCollection<String> AV18LegTipoTra ;
}

