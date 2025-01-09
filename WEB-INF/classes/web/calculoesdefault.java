package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculoesdefault extends GXProcedure
{
   public calculoesdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculoesdefault.class ), "" );
   }

   public calculoesdefault( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              byte aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String aP4 ,
                              java.math.BigDecimal aP5 ,
                              short aP6 ,
                              byte aP7 ,
                              byte aP8 ,
                              short aP9 ,
                              short aP10 ,
                              boolean aP11 ,
                              boolean aP12 ,
                              boolean aP13 ,
                              boolean aP14 ,
                              boolean aP15 ,
                              short aP16 ,
                              short aP17 ,
                              String aP18 )
   {
      calculoesdefault.this.aP19 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
      return aP19[0];
   }

   public void execute( short aP0 ,
                        byte aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.math.BigDecimal aP5 ,
                        short aP6 ,
                        byte aP7 ,
                        byte aP8 ,
                        short aP9 ,
                        short aP10 ,
                        boolean aP11 ,
                        boolean aP12 ,
                        boolean aP13 ,
                        boolean aP14 ,
                        boolean aP15 ,
                        short aP16 ,
                        short aP17 ,
                        String aP18 ,
                        boolean[] aP19 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
   }

   private void execute_int( short aP0 ,
                             byte aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.math.BigDecimal aP5 ,
                             short aP6 ,
                             byte aP7 ,
                             byte aP8 ,
                             short aP9 ,
                             short aP10 ,
                             boolean aP11 ,
                             boolean aP12 ,
                             boolean aP13 ,
                             boolean aP14 ,
                             boolean aP15 ,
                             short aP16 ,
                             short aP17 ,
                             String aP18 ,
                             boolean[] aP19 )
   {
      calculoesdefault.this.AV9PaiCod = aP0;
      calculoesdefault.this.AV10PaiBaseClaseLeg = aP1;
      calculoesdefault.this.AV27PaiBaseTipo = aP2;
      calculoesdefault.this.AV26PaiBaseCod1 = aP3;
      calculoesdefault.this.AV11PaiBaseCod2 = aP4;
      calculoesdefault.this.AV8PaiBasePlus = aP5;
      calculoesdefault.this.AV12PaiLicDLim = aP6;
      calculoesdefault.this.AV25PaiLicDSeman = aP7;
      calculoesdefault.this.AV24PaiLicDMes = aP8;
      calculoesdefault.this.AV13PaiLicDSemes = aP9;
      calculoesdefault.this.AV14PaiLicDAnual = aP10;
      calculoesdefault.this.AV23PaiLicAdju = aP11;
      calculoesdefault.this.AV15PaiLicAdjuObl = aP12;
      calculoesdefault.this.AV22PaiLicNecAut = aP13;
      calculoesdefault.this.AV20PaiLicIngMot = aP14;
      calculoesdefault.this.AV21PaiLicMotObl = aP15;
      calculoesdefault.this.AV16PaiBasePromCnt1 = aP16;
      calculoesdefault.this.AV17PaiBasePromCnt2 = aP17;
      calculoesdefault.this.AV18PaiBasePromTCnt = aP18;
      calculoesdefault.this.aP19 = aP19;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ST2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), Byte.valueOf(AV10PaiBaseClaseLeg), AV27PaiBaseTipo, AV26PaiBaseCod1, AV11PaiBaseCod2, AV8PaiBasePlus, Short.valueOf(AV12PaiLicDLim), Byte.valueOf(AV25PaiLicDSeman), Byte.valueOf(AV24PaiLicDMes), Short.valueOf(AV13PaiLicDSemes), Short.valueOf(AV14PaiLicDAnual), Boolean.valueOf(AV23PaiLicAdju), Boolean.valueOf(AV15PaiLicAdjuObl), Boolean.valueOf(AV22PaiLicNecAut), Boolean.valueOf(AV20PaiLicIngMot), Boolean.valueOf(AV21PaiLicMotObl), Short.valueOf(AV16PaiBasePromCnt1), Short.valueOf(AV17PaiBasePromCnt2), AV18PaiBasePromTCnt});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1453PaiBasePromTCnt = P01ST2_A1453PaiBasePromTCnt[0] ;
         A1452PaiBasePromCnt2 = P01ST2_A1452PaiBasePromCnt2[0] ;
         A1451PaiBasePromCnt1 = P01ST2_A1451PaiBasePromCnt1[0] ;
         A1638PaiLicMotObl = P01ST2_A1638PaiLicMotObl[0] ;
         A1637PaiLicIngMot = P01ST2_A1637PaiLicIngMot[0] ;
         A1636PaiLicNecAut = P01ST2_A1636PaiLicNecAut[0] ;
         A1635PaiLicAdjuObl = P01ST2_A1635PaiLicAdjuObl[0] ;
         A1634PaiLicAdju = P01ST2_A1634PaiLicAdju[0] ;
         A1633PaiLicDAnual = P01ST2_A1633PaiLicDAnual[0] ;
         A1632PaiLicDSemes = P01ST2_A1632PaiLicDSemes[0] ;
         A1631PaiLicDMes = P01ST2_A1631PaiLicDMes[0] ;
         A1630PaiLicDSeman = P01ST2_A1630PaiLicDSeman[0] ;
         A1629PaiLicDLim = P01ST2_A1629PaiLicDLim[0] ;
         A1444PaiBasePlus = P01ST2_A1444PaiBasePlus[0] ;
         A1443PaiBaseCod2 = P01ST2_A1443PaiBaseCod2[0] ;
         A1442PaiBaseCod1 = P01ST2_A1442PaiBaseCod1[0] ;
         A1441PaiBaseTipo = P01ST2_A1441PaiBaseTipo[0] ;
         A1440PaiBaseClaseLeg = P01ST2_A1440PaiBaseClaseLeg[0] ;
         A46PaiCod = P01ST2_A46PaiCod[0] ;
         AV19defaultEs = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP19[0] = calculoesdefault.this.AV19defaultEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01ST2_A1453PaiBasePromTCnt = new String[] {""} ;
      P01ST2_A1452PaiBasePromCnt2 = new short[1] ;
      P01ST2_A1451PaiBasePromCnt1 = new short[1] ;
      P01ST2_A1638PaiLicMotObl = new boolean[] {false} ;
      P01ST2_A1637PaiLicIngMot = new boolean[] {false} ;
      P01ST2_A1636PaiLicNecAut = new boolean[] {false} ;
      P01ST2_A1635PaiLicAdjuObl = new boolean[] {false} ;
      P01ST2_A1634PaiLicAdju = new boolean[] {false} ;
      P01ST2_A1633PaiLicDAnual = new short[1] ;
      P01ST2_A1632PaiLicDSemes = new short[1] ;
      P01ST2_A1631PaiLicDMes = new byte[1] ;
      P01ST2_A1630PaiLicDSeman = new byte[1] ;
      P01ST2_A1629PaiLicDLim = new short[1] ;
      P01ST2_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ST2_A1443PaiBaseCod2 = new String[] {""} ;
      P01ST2_A1442PaiBaseCod1 = new String[] {""} ;
      P01ST2_A1441PaiBaseTipo = new String[] {""} ;
      P01ST2_A1440PaiBaseClaseLeg = new byte[1] ;
      P01ST2_A46PaiCod = new short[1] ;
      A1453PaiBasePromTCnt = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1443PaiBaseCod2 = "" ;
      A1442PaiBaseCod1 = "" ;
      A1441PaiBaseTipo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculoesdefault__default(),
         new Object[] {
             new Object[] {
            P01ST2_A1453PaiBasePromTCnt, P01ST2_A1452PaiBasePromCnt2, P01ST2_A1451PaiBasePromCnt1, P01ST2_A1638PaiLicMotObl, P01ST2_A1637PaiLicIngMot, P01ST2_A1636PaiLicNecAut, P01ST2_A1635PaiLicAdjuObl, P01ST2_A1634PaiLicAdju, P01ST2_A1633PaiLicDAnual, P01ST2_A1632PaiLicDSemes,
            P01ST2_A1631PaiLicDMes, P01ST2_A1630PaiLicDSeman, P01ST2_A1629PaiLicDLim, P01ST2_A1444PaiBasePlus, P01ST2_A1443PaiBaseCod2, P01ST2_A1442PaiBaseCod1, P01ST2_A1441PaiBaseTipo, P01ST2_A1440PaiBaseClaseLeg, P01ST2_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10PaiBaseClaseLeg ;
   private byte AV25PaiLicDSeman ;
   private byte AV24PaiLicDMes ;
   private byte A1631PaiLicDMes ;
   private byte A1630PaiLicDSeman ;
   private byte A1440PaiBaseClaseLeg ;
   private short AV9PaiCod ;
   private short AV12PaiLicDLim ;
   private short AV13PaiLicDSemes ;
   private short AV14PaiLicDAnual ;
   private short AV16PaiBasePromCnt1 ;
   private short AV17PaiBasePromCnt2 ;
   private short A1452PaiBasePromCnt2 ;
   private short A1451PaiBasePromCnt1 ;
   private short A1633PaiLicDAnual ;
   private short A1632PaiLicDSemes ;
   private short A1629PaiLicDLim ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV8PaiBasePlus ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String AV27PaiBaseTipo ;
   private String AV26PaiBaseCod1 ;
   private String AV11PaiBaseCod2 ;
   private String AV18PaiBasePromTCnt ;
   private String scmdbuf ;
   private String A1453PaiBasePromTCnt ;
   private String A1443PaiBaseCod2 ;
   private String A1442PaiBaseCod1 ;
   private String A1441PaiBaseTipo ;
   private boolean AV23PaiLicAdju ;
   private boolean AV15PaiLicAdjuObl ;
   private boolean AV22PaiLicNecAut ;
   private boolean AV20PaiLicIngMot ;
   private boolean AV21PaiLicMotObl ;
   private boolean AV19defaultEs ;
   private boolean A1638PaiLicMotObl ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1634PaiLicAdju ;
   private boolean[] aP19 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ST2_A1453PaiBasePromTCnt ;
   private short[] P01ST2_A1452PaiBasePromCnt2 ;
   private short[] P01ST2_A1451PaiBasePromCnt1 ;
   private boolean[] P01ST2_A1638PaiLicMotObl ;
   private boolean[] P01ST2_A1637PaiLicIngMot ;
   private boolean[] P01ST2_A1636PaiLicNecAut ;
   private boolean[] P01ST2_A1635PaiLicAdjuObl ;
   private boolean[] P01ST2_A1634PaiLicAdju ;
   private short[] P01ST2_A1633PaiLicDAnual ;
   private short[] P01ST2_A1632PaiLicDSemes ;
   private byte[] P01ST2_A1631PaiLicDMes ;
   private byte[] P01ST2_A1630PaiLicDSeman ;
   private short[] P01ST2_A1629PaiLicDLim ;
   private java.math.BigDecimal[] P01ST2_A1444PaiBasePlus ;
   private String[] P01ST2_A1443PaiBaseCod2 ;
   private String[] P01ST2_A1442PaiBaseCod1 ;
   private String[] P01ST2_A1441PaiBaseTipo ;
   private byte[] P01ST2_A1440PaiBaseClaseLeg ;
   private short[] P01ST2_A46PaiCod ;
}

final  class calculoesdefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ST2", "SELECT PaiBasePromTCnt, PaiBasePromCnt2, PaiBasePromCnt1, PaiLicMotObl, PaiLicIngMot, PaiLicNecAut, PaiLicAdjuObl, PaiLicAdju, PaiLicDAnual, PaiLicDSemes, PaiLicDMes, PaiLicDSeman, PaiLicDLim, PaiBasePlus, PaiBaseCod2, PaiBaseCod1, PaiBaseTipo, PaiBaseClaseLeg, PaiCod FROM Paisbase_calculo WHERE (PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?)) AND (PaiBasePlus = ?) AND (PaiLicDLim = ?) AND (PaiLicDSeman = ?) AND (PaiLicDMes = ?) AND (PaiLicDSemes = ?) AND (PaiLicDAnual = ?) AND (PaiLicAdju = ?) AND (PaiLicAdjuObl = ?) AND (PaiLicNecAut = ?) AND (PaiLicIngMot = ?) AND (PaiLicMotObl = ?) AND (PaiBasePromCnt1 = ?) AND (PaiBasePromCnt2 = ?) AND (PaiBasePromTCnt = ( ?)) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,4);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               ((String[]) buf[16])[0] = rslt.getString(17, 20);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setString(19, (String)parms[18], 20);
               return;
      }
   }

}

