package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtsueldojornal extends GXProcedure
{
   public obtsueldojornal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtsueldojornal.class ), "" );
   }

   public obtsueldojornal( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           String[] aP5 )
   {
      obtsueldojornal.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String[] aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String[] aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      obtsueldojornal.this.AV11CliCod = aP0;
      obtsueldojornal.this.AV8EmpCod = aP1;
      obtsueldojornal.this.AV17LiqNro = aP2;
      obtsueldojornal.this.AV9LegNumero = aP3;
      obtsueldojornal.this.AV12LiqPeriodo = aP4;
      obtsueldojornal.this.aP5 = aP5;
      obtsueldojornal.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10SueldoJornal = DecimalUtil.ZERO ;
      GXv_char1[0] = AV19LegCatCodigo ;
      GXv_char2[0] = AV18LegConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV17LiqNro, AV9LegNumero, GXv_char1, GXv_char2) ;
      obtsueldojornal.this.AV19LegCatCodigo = GXv_char1[0] ;
      obtsueldojornal.this.AV18LegConveCodigo = GXv_char2[0] ;
      /* Using cursor P003O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P003O2_A6LegNumero[0] ;
         A1EmpCod = P003O2_A1EmpCod[0] ;
         A3CliCod = P003O2_A3CliCod[0] ;
         A22LegPaiCod = P003O2_A22LegPaiCod[0] ;
         n22LegPaiCod = P003O2_n22LegPaiCod[0] ;
         A235LegClase = P003O2_A235LegClase[0] ;
         if ( ! (GXutil.strcmp("", AV19LegCatCodigo)==0) && ! (GXutil.strcmp("", AV18LegConveCodigo)==0) )
         {
            GXv_int3[0] = AV15CliConveVer ;
            new web.getversiondelegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_int3) ;
            obtsueldojornal.this.AV15CliConveVer = GXv_int3[0] ;
            GXv_int4[0] = AV22CliPaiConve ;
            new web.getpaisdeconvenio(remoteHandle, context).execute( AV18LegConveCodigo, A22LegPaiCod, GXv_int4) ;
            obtsueldojornal.this.AV22CliPaiConve = GXv_int4[0] ;
            GXv_boolean5[0] = false ;
            GXv_char2[0] = AV14error ;
            GXv_decimal6[0] = AV10SueldoJornal ;
            new web.getescalasalarialvigente3(remoteHandle, context).execute( AV15CliConveVer, AV22CliPaiConve, AV18LegConveCodigo, AV19LegCatCodigo, AV12LiqPeriodo, A235LegClase, httpContext.getMessage( "TOTAL", ""), GXv_boolean5, GXv_char2, GXv_decimal6) ;
            obtsueldojornal.this.AV14error = GXv_char2[0] ;
            obtsueldojornal.this.AV10SueldoJornal = GXv_decimal6[0] ;
         }
         else
         {
            GXv_decimal6[0] = AV10SueldoJornal ;
            GXv_char2[0] = AV20LegSuelTipo ;
            GXv_int4[0] = (short)(0) ;
            GXv_boolean5[0] = false ;
            new web.getlegajosueldoultimo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV17LiqNro, AV9LegNumero, AV12LiqPeriodo, GXv_decimal6, GXv_char2, GXv_int4, GXv_boolean5) ;
            obtsueldojornal.this.AV10SueldoJornal = GXv_decimal6[0] ;
            obtsueldojornal.this.AV20LegSuelTipo = GXv_char2[0] ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_int7[0] = AV16LegClase ;
      GXv_char2[0] = AV21LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, GXv_int7, GXv_char2) ;
      obtsueldojornal.this.AV16LegClase = GXv_int7[0] ;
      obtsueldojornal.this.AV21LegModTra = GXv_char2[0] ;
      if ( AV16LegClase == 1 )
      {
         AV13OrigSueldoJornal = AV10SueldoJornal ;
         GXv_decimal6[0] = AV10SueldoJornal ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         new web.reducirporparcial(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, AV12LiqPeriodo, AV13OrigSueldoJornal, GXv_decimal6, GXv_decimal8, GXv_decimal9) ;
         obtsueldojornal.this.AV10SueldoJornal = GXv_decimal6[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = obtsueldojornal.this.AV14error;
      this.aP6[0] = obtsueldojornal.this.AV10SueldoJornal;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      AV10SueldoJornal = DecimalUtil.ZERO ;
      AV19LegCatCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV18LegConveCodigo = "" ;
      scmdbuf = "" ;
      P003O2_A6LegNumero = new int[1] ;
      P003O2_A1EmpCod = new short[1] ;
      P003O2_A3CliCod = new int[1] ;
      P003O2_A22LegPaiCod = new short[1] ;
      P003O2_n22LegPaiCod = new boolean[] {false} ;
      P003O2_A235LegClase = new byte[1] ;
      GXv_int3 = new int[1] ;
      AV20LegSuelTipo = "" ;
      GXv_int4 = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV21LegModTra = "" ;
      GXv_char2 = new String[1] ;
      AV13OrigSueldoJornal = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtsueldojornal__default(),
         new Object[] {
             new Object[] {
            P003O2_A6LegNumero, P003O2_A1EmpCod, P003O2_A3CliCod, P003O2_A22LegPaiCod, P003O2_n22LegPaiCod, P003O2_A235LegClase
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private byte AV16LegClase ;
   private byte GXv_int7[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short AV22CliPaiConve ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV17LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV15CliConveVer ;
   private int GXv_int3[] ;
   private java.math.BigDecimal AV10SueldoJornal ;
   private java.math.BigDecimal AV13OrigSueldoJornal ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private String AV19LegCatCodigo ;
   private String GXv_char1[] ;
   private String AV18LegConveCodigo ;
   private String scmdbuf ;
   private String AV20LegSuelTipo ;
   private String AV21LegModTra ;
   private String GXv_char2[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean n22LegPaiCod ;
   private boolean GXv_boolean5[] ;
   private String AV14error ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P003O2_A6LegNumero ;
   private short[] P003O2_A1EmpCod ;
   private int[] P003O2_A3CliCod ;
   private short[] P003O2_A22LegPaiCod ;
   private boolean[] P003O2_n22LegPaiCod ;
   private byte[] P003O2_A235LegClase ;
}

final  class obtsueldojornal__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003O2", "SELECT LegNumero, EmpCod, CliCod, LegPaiCod, LegClase FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
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
               return;
      }
   }

}

