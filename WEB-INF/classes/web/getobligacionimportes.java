package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobligacionimportes extends GXProcedure
{
   public getobligacionimportes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobligacionimportes.class ), "" );
   }

   public getobligacionimportes( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           short aP3 ,
                           short[] aP4 ,
                           java.math.BigDecimal[] aP5 ,
                           short[] aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           java.math.BigDecimal[] aP8 ,
                           String[] aP9 ,
                           String[] aP10 ,
                           String[] aP11 )
   {
      getobligacionimportes.this.aP12 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        short[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        short[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             short[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             short[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      getobligacionimportes.this.AV8CliCod = aP0;
      getobligacionimportes.this.AV9EmpCod = aP1;
      getobligacionimportes.this.AV10LegNumero = aP2;
      getobligacionimportes.this.AV11OblSecuencial = aP3;
      getobligacionimportes.this.aP4 = aP4;
      getobligacionimportes.this.aP5 = aP5;
      getobligacionimportes.this.aP6 = aP6;
      getobligacionimportes.this.aP7 = aP7;
      getobligacionimportes.this.aP8 = aP8;
      getobligacionimportes.this.aP9 = aP9;
      getobligacionimportes.this.aP10 = aP10;
      getobligacionimportes.this.aP11 = aP11;
      getobligacionimportes.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19LiqDCalculado = (byte)(1) ;
      /* Using cursor P01AE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV11OblSecuencial)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1163TipoOblSec = P01AE2_A1163TipoOblSec[0] ;
         A1172OblSecuencial = P01AE2_A1172OblSecuencial[0] ;
         A6LegNumero = P01AE2_A6LegNumero[0] ;
         A1EmpCod = P01AE2_A1EmpCod[0] ;
         A3CliCod = P01AE2_A3CliCod[0] ;
         A1176OblTotal = P01AE2_A1176OblTotal[0] ;
         A1177OblCanCuo = P01AE2_A1177OblCanCuo[0] ;
         A1178OblImpFij = P01AE2_A1178OblImpFij[0] ;
         A1179OblPorc = P01AE2_A1179OblPorc[0] ;
         A1161EmbargaSec = P01AE2_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P01AE2_n1161EmbargaSec[0] ;
         A2343OblConcepto = P01AE2_A2343OblConcepto[0] ;
         A2345OblTipoMov = P01AE2_A2345OblTipoMov[0] ;
         A1195OblLiqNro = P01AE2_A1195OblLiqNro[0] ;
         n1195OblLiqNro = P01AE2_n1195OblLiqNro[0] ;
         A1169OblConCodigo = P01AE2_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P01AE2_n1169OblConCodigo[0] ;
         A1161EmbargaSec = P01AE2_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P01AE2_n1161EmbargaSec[0] ;
         AV12OblTotal = A1176OblTotal ;
         AV14OblCanCuo = A1177OblCanCuo ;
         AV13OblImpFij = A1178OblImpFij ;
         AV15OblPorc = A1179OblPorc ;
         AV21EmbargaSec = A1161EmbargaSec ;
         AV23OblConcepto = A2343OblConcepto ;
         AV24OblTipoMov = A2345OblTipoMov ;
         if ( ! (GXutil.strcmp("", A1169OblConCodigo)==0) && ! (0==A1195OblLiqNro) )
         {
            GXv_decimal1[0] = AV12OblTotal ;
            GXv_boolean2[0] = AV22existe ;
            GXv_int3[0] = AV19LiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A1195OblLiqNro, AV10LegNumero, A1169OblConCodigo, AV17ProcesoLiquidacion, AV18insertandoConceptos, GXv_decimal1, GXv_boolean2, GXv_int3) ;
            getobligacionimportes.this.AV12OblTotal = GXv_decimal1[0] ;
            getobligacionimportes.this.AV22existe = GXv_boolean2[0] ;
            getobligacionimportes.this.AV19LiqDCalculado = GXv_int3[0] ;
            if ( ( AV19LiqDCalculado == 0 ) && ( AV22existe ) )
            {
               AV20error = httpContext.getMessage( "Error al recuperar importe de liquidación ", "") + GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) + httpContext.getMessage( " concepto ", "") + GXutil.trim( A1169OblConCodigo) ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getobligacionimportes.this.AV21EmbargaSec;
      this.aP5[0] = getobligacionimportes.this.AV12OblTotal;
      this.aP6[0] = getobligacionimportes.this.AV14OblCanCuo;
      this.aP7[0] = getobligacionimportes.this.AV13OblImpFij;
      this.aP8[0] = getobligacionimportes.this.AV15OblPorc;
      this.aP9[0] = getobligacionimportes.this.AV23OblConcepto;
      this.aP10[0] = getobligacionimportes.this.AV24OblTipoMov;
      this.aP11[0] = getobligacionimportes.this.AV20error;
      this.aP12[0] = getobligacionimportes.this.AV19LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12OblTotal = DecimalUtil.ZERO ;
      AV13OblImpFij = DecimalUtil.ZERO ;
      AV15OblPorc = DecimalUtil.ZERO ;
      AV23OblConcepto = "" ;
      AV24OblTipoMov = "" ;
      AV20error = "" ;
      scmdbuf = "" ;
      P01AE2_A1163TipoOblSec = new short[1] ;
      P01AE2_A1172OblSecuencial = new short[1] ;
      P01AE2_A6LegNumero = new int[1] ;
      P01AE2_A1EmpCod = new short[1] ;
      P01AE2_A3CliCod = new int[1] ;
      P01AE2_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AE2_A1177OblCanCuo = new short[1] ;
      P01AE2_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AE2_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AE2_A1161EmbargaSec = new short[1] ;
      P01AE2_n1161EmbargaSec = new boolean[] {false} ;
      P01AE2_A2343OblConcepto = new String[] {""} ;
      P01AE2_A2345OblTipoMov = new String[] {""} ;
      P01AE2_A1195OblLiqNro = new int[1] ;
      P01AE2_n1195OblLiqNro = new boolean[] {false} ;
      P01AE2_A1169OblConCodigo = new String[] {""} ;
      P01AE2_n1169OblConCodigo = new boolean[] {false} ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      A2343OblConcepto = "" ;
      A2345OblTipoMov = "" ;
      A1169OblConCodigo = "" ;
      AV17ProcesoLiquidacion = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_int3 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobligacionimportes__default(),
         new Object[] {
             new Object[] {
            P01AE2_A1163TipoOblSec, P01AE2_A1172OblSecuencial, P01AE2_A6LegNumero, P01AE2_A1EmpCod, P01AE2_A3CliCod, P01AE2_A1176OblTotal, P01AE2_A1177OblCanCuo, P01AE2_A1178OblImpFij, P01AE2_A1179OblPorc, P01AE2_A1161EmbargaSec,
            P01AE2_n1161EmbargaSec, P01AE2_A2343OblConcepto, P01AE2_A2345OblTipoMov, P01AE2_A1195OblLiqNro, P01AE2_n1195OblLiqNro, P01AE2_A1169OblConCodigo, P01AE2_n1169OblConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV19LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV9EmpCod ;
   private short AV11OblSecuencial ;
   private short AV21EmbargaSec ;
   private short AV14OblCanCuo ;
   private short A1163TipoOblSec ;
   private short A1172OblSecuencial ;
   private short A1EmpCod ;
   private short A1177OblCanCuo ;
   private short A1161EmbargaSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1195OblLiqNro ;
   private java.math.BigDecimal AV12OblTotal ;
   private java.math.BigDecimal AV13OblImpFij ;
   private java.math.BigDecimal AV15OblPorc ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV23OblConcepto ;
   private String AV24OblTipoMov ;
   private String scmdbuf ;
   private String A2343OblConcepto ;
   private String A2345OblTipoMov ;
   private String A1169OblConCodigo ;
   private String AV17ProcesoLiquidacion ;
   private boolean n1161EmbargaSec ;
   private boolean n1195OblLiqNro ;
   private boolean n1169OblConCodigo ;
   private boolean AV18insertandoConceptos ;
   private boolean AV22existe ;
   private boolean GXv_boolean2[] ;
   private String AV20error ;
   private byte[] aP12 ;
   private short[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private short[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private IDataStoreProvider pr_default ;
   private short[] P01AE2_A1163TipoOblSec ;
   private short[] P01AE2_A1172OblSecuencial ;
   private int[] P01AE2_A6LegNumero ;
   private short[] P01AE2_A1EmpCod ;
   private int[] P01AE2_A3CliCod ;
   private java.math.BigDecimal[] P01AE2_A1176OblTotal ;
   private short[] P01AE2_A1177OblCanCuo ;
   private java.math.BigDecimal[] P01AE2_A1178OblImpFij ;
   private java.math.BigDecimal[] P01AE2_A1179OblPorc ;
   private short[] P01AE2_A1161EmbargaSec ;
   private boolean[] P01AE2_n1161EmbargaSec ;
   private String[] P01AE2_A2343OblConcepto ;
   private String[] P01AE2_A2345OblTipoMov ;
   private int[] P01AE2_A1195OblLiqNro ;
   private boolean[] P01AE2_n1195OblLiqNro ;
   private String[] P01AE2_A1169OblConCodigo ;
   private boolean[] P01AE2_n1169OblConCodigo ;
}

final  class getobligacionimportes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AE2", "SELECT T1.TipoOblSec, T1.OblSecuencial, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.OblTotal, T1.OblCanCuo, T1.OblImpFij, T1.OblPorc, T2.EmbargaSec, T1.OblConcepto, T1.OblTipoMov, T1.OblLiqNro, T1.OblConCodigo FROM (Obligacion T1 INNER JOIN tipo_obligacion T2 ON T2.TipoOblSec = T1.TipoOblSec) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.OblSecuencial = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.OblSecuencial ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(11, 10);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

