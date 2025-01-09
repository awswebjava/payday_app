package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenio_base_calculo extends GXProcedure
{
   public newconvenio_base_calculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenio_base_calculo.class ), "" );
   }

   public newconvenio_base_calculo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        short aP8 ,
                        byte aP9 ,
                        byte aP10 ,
                        short aP11 ,
                        short aP12 ,
                        boolean aP13 ,
                        boolean aP14 ,
                        boolean aP15 ,
                        boolean aP16 ,
                        boolean aP17 ,
                        short aP18 ,
                        short aP19 ,
                        String aP20 ,
                        int aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             short aP8 ,
                             byte aP9 ,
                             byte aP10 ,
                             short aP11 ,
                             short aP12 ,
                             boolean aP13 ,
                             boolean aP14 ,
                             boolean aP15 ,
                             boolean aP16 ,
                             boolean aP17 ,
                             short aP18 ,
                             short aP19 ,
                             String aP20 ,
                             int aP21 )
   {
      newconvenio_base_calculo.this.AV29CliCod = aP0;
      newconvenio_base_calculo.this.AV28CliPaiConve = aP1;
      newconvenio_base_calculo.this.AV27CliConvenio = aP2;
      newconvenio_base_calculo.this.AV26ConveBaseClaseLeg = aP3;
      newconvenio_base_calculo.this.AV25ConveBaseTipo = aP4;
      newconvenio_base_calculo.this.AV24ConveBaseCod1 = aP5;
      newconvenio_base_calculo.this.AV23ConveBaseCod2 = aP6;
      newconvenio_base_calculo.this.AV22ConveBasePlus = aP7;
      newconvenio_base_calculo.this.AV21ConveLicDLim = aP8;
      newconvenio_base_calculo.this.AV20ConveLicDSeman = aP9;
      newconvenio_base_calculo.this.AV19ConveLicDMes = aP10;
      newconvenio_base_calculo.this.AV18ConveLicDSemes = aP11;
      newconvenio_base_calculo.this.AV17ConveLicDAnual = aP12;
      newconvenio_base_calculo.this.AV16ConveLicAdju = aP13;
      newconvenio_base_calculo.this.AV15ConveLicAdjuObl = aP14;
      newconvenio_base_calculo.this.AV14ConveLicNecAut = aP15;
      newconvenio_base_calculo.this.AV13ConveLicIngMot = aP16;
      newconvenio_base_calculo.this.AV12ConveLicMotObl = aP17;
      newconvenio_base_calculo.this.AV11ConveBasePromCnt1 = aP18;
      newconvenio_base_calculo.this.AV10ConveBasePromCnt2 = aP19;
      newconvenio_base_calculo.this.AV9ConveBasePromTCnt = aP20;
      newconvenio_base_calculo.this.AV8ConveBaseRelSec = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Convenio_base_calculo

      */
      A3CliCod = AV29CliCod ;
      A1564CliPaiConve = AV28CliPaiConve ;
      A1565CliConvenio = AV27CliConvenio ;
      A1454ConveBaseClaseLeg = AV26ConveBaseClaseLeg ;
      A1455ConveBaseTipo = AV25ConveBaseTipo ;
      A1456ConveBaseCod1 = AV24ConveBaseCod1 ;
      A1457ConveBaseCod2 = AV23ConveBaseCod2 ;
      A1458ConveBasePlus = AV22ConveBasePlus ;
      A1610ConveLicDLim = AV21ConveLicDLim ;
      A1611ConveLicDSeman = AV20ConveLicDSeman ;
      A1612ConveLicDMes = AV19ConveLicDMes ;
      A1613ConveLicDSemes = AV18ConveLicDSemes ;
      A1614ConveLicDAnual = AV17ConveLicDAnual ;
      A1615ConveLicAdju = AV16ConveLicAdju ;
      A1616ConveLicAdjuObl = AV15ConveLicAdjuObl ;
      A1617ConveLicNecAut = AV14ConveLicNecAut ;
      A1618ConveLicIngMot = AV13ConveLicIngMot ;
      A1619ConveLicMotObl = AV12ConveLicMotObl ;
      A1465ConveBasePromCnt1 = AV11ConveBasePromCnt1 ;
      A1466ConveBasePromCnt2 = AV10ConveBasePromCnt2 ;
      A1467ConveBasePromTCnt = AV9ConveBasePromTCnt ;
      A2060ConveBaseRelSec = AV8ConveBaseRelSec ;
      A2061ConveBaseRelRef = "" ;
      A2062ConveBaseOld = "" ;
      /* Using cursor P01XW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2, A1458ConveBasePlus, Short.valueOf(A1610ConveLicDLim), Byte.valueOf(A1611ConveLicDSeman), Byte.valueOf(A1612ConveLicDMes), Short.valueOf(A1613ConveLicDSemes), Short.valueOf(A1614ConveLicDAnual), Boolean.valueOf(A1615ConveLicAdju), Boolean.valueOf(A1616ConveLicAdjuObl), Boolean.valueOf(A1617ConveLicNecAut), Boolean.valueOf(A1618ConveLicIngMot), Boolean.valueOf(A1619ConveLicMotObl), Short.valueOf(A1465ConveBasePromCnt1), Short.valueOf(A1466ConveBasePromCnt2), A1467ConveBasePromTCnt, Integer.valueOf(A2060ConveBaseRelSec), A2061ConveBaseRelRef, A2062ConveBaseOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenio_base_calculo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1565CliConvenio = "" ;
      A1455ConveBaseTipo = "" ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1467ConveBasePromTCnt = "" ;
      A2061ConveBaseRelRef = "" ;
      A2062ConveBaseOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenio_base_calculo__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV26ConveBaseClaseLeg ;
   private byte AV20ConveLicDSeman ;
   private byte AV19ConveLicDMes ;
   private byte A1454ConveBaseClaseLeg ;
   private byte A1611ConveLicDSeman ;
   private byte A1612ConveLicDMes ;
   private short AV28CliPaiConve ;
   private short AV21ConveLicDLim ;
   private short AV18ConveLicDSemes ;
   private short AV17ConveLicDAnual ;
   private short AV11ConveBasePromCnt1 ;
   private short AV10ConveBasePromCnt2 ;
   private short A1564CliPaiConve ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short Gx_err ;
   private int AV29CliCod ;
   private int AV8ConveBaseRelSec ;
   private int GX_INS210 ;
   private int A3CliCod ;
   private int A2060ConveBaseRelSec ;
   private java.math.BigDecimal AV22ConveBasePlus ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private String AV27CliConvenio ;
   private String AV25ConveBaseTipo ;
   private String AV24ConveBaseCod1 ;
   private String AV23ConveBaseCod2 ;
   private String AV9ConveBasePromTCnt ;
   private String A1565CliConvenio ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private String A1467ConveBasePromTCnt ;
   private String Gx_emsg ;
   private boolean AV16ConveLicAdju ;
   private boolean AV15ConveLicAdjuObl ;
   private boolean AV14ConveLicNecAut ;
   private boolean AV13ConveLicIngMot ;
   private boolean AV12ConveLicMotObl ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private String A2062ConveBaseOld ;
   private String A2061ConveBaseRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenio_base_calculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01XW2", "SAVEPOINT gxupdate;INSERT INTO Convenio_base_calculo(CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBasePlus, ConveLicDLim, ConveLicDSeman, ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt, ConveBaseRelSec, ConveBaseRelRef, ConveBaseOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setVarchar(23, (String)parms[22], 40, false);
               stmt.setNLongVarchar(24, (String)parms[23], false);
               return;
      }
   }

}

