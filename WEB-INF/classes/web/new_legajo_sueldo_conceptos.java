package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_legajo_sueldo_conceptos extends GXProcedure
{
   public new_legajo_sueldo_conceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_legajo_sueldo_conceptos.class ), "" );
   }

   public new_legajo_sueldo_conceptos( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             short aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.math.BigDecimal aP11 ,
                             String aP12 ,
                             long aP13 ,
                             String aP14 )
   {
      new_legajo_sueldo_conceptos.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        short aP8 ,
                        java.math.BigDecimal aP9 ,
                        java.math.BigDecimal aP10 ,
                        java.math.BigDecimal aP11 ,
                        String aP12 ,
                        long aP13 ,
                        String aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             short aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.math.BigDecimal aP11 ,
                             String aP12 ,
                             long aP13 ,
                             String aP14 ,
                             String[] aP15 )
   {
      new_legajo_sueldo_conceptos.this.AV19CliCod = aP0;
      new_legajo_sueldo_conceptos.this.AV18EmpCod = aP1;
      new_legajo_sueldo_conceptos.this.AV17LegNumero = aP2;
      new_legajo_sueldo_conceptos.this.AV16LegSuelSec = aP3;
      new_legajo_sueldo_conceptos.this.AV15LegSuelConcepto = aP4;
      new_legajo_sueldo_conceptos.this.AV23sueldoConCodigo = aP5;
      new_legajo_sueldo_conceptos.this.AV24EmpTipoExp = aP6;
      new_legajo_sueldo_conceptos.this.AV14LegSuelConDesc = aP7;
      new_legajo_sueldo_conceptos.this.AV13LegSuelConSec = aP8;
      new_legajo_sueldo_conceptos.this.AV12LegSuelConCnt = aP9;
      new_legajo_sueldo_conceptos.this.AV11LegSuelConValU = aP10;
      new_legajo_sueldo_conceptos.this.AV10LegSuelConImp = aP11;
      new_legajo_sueldo_conceptos.this.AV9LegSuelConFor = aP12;
      new_legajo_sueldo_conceptos.this.AV8LegSuelConOrdE = aP13;
      new_legajo_sueldo_conceptos.this.AV20LegSuelLiqDLog = aP14;
      new_legajo_sueldo_conceptos.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV21ConMostrarPos ;
      GXv_boolean2[0] = AV22ConErrorSiCero ;
      new web.getdatosconceptocero(remoteHandle, context).execute( AV19CliCod, AV15LegSuelConcepto, GXv_boolean1, GXv_boolean2) ;
      new_legajo_sueldo_conceptos.this.AV21ConMostrarPos = GXv_boolean1[0] ;
      new_legajo_sueldo_conceptos.this.AV22ConErrorSiCero = GXv_boolean2[0] ;
      GXv_char3[0] = AV25error ;
      GXv_boolean2[0] = false ;
      GXv_boolean1[0] = false ;
      GXv_int4[0] = AV26MostrarConcepto ;
      new web.logicaerrorymostrarsicero(remoteHandle, context).execute( AV10LegSuelConImp, AV21ConMostrarPos, AV22ConErrorSiCero, AV15LegSuelConcepto, AV23sueldoConCodigo, AV24EmpTipoExp, DecimalUtil.doubleToDec(1), GXv_char3, GXv_boolean2, GXv_boolean1, GXv_int4) ;
      new_legajo_sueldo_conceptos.this.AV25error = GXv_char3[0] ;
      new_legajo_sueldo_conceptos.this.AV26MostrarConcepto = GXv_int4[0] ;
      if ( ( AV26MostrarConcepto == 3 ) && (GXutil.strcmp("", AV25error)==0) )
      {
         /*
            INSERT RECORD ON TABLE Legajo_sueldosConceptos

         */
         A3CliCod = AV19CliCod ;
         A1EmpCod = AV18EmpCod ;
         A6LegNumero = AV17LegNumero ;
         A1135LegSuelSec = AV16LegSuelSec ;
         A2349LegSuelConcepto = AV15LegSuelConcepto ;
         A2351LegSuelConSec = AV13LegSuelConSec ;
         A2352LegSuelConCnt = AV12LegSuelConCnt ;
         A2353LegSuelConValU = AV11LegSuelConValU ;
         A2354LegSuelConImp = AV10LegSuelConImp ;
         A2355LegSuelConFor = AV9LegSuelConFor ;
         A2356LegSuelConOrdE = AV8LegSuelConOrdE ;
         A2358LegSuelLiqDLog = AV20LegSuelLiqDLog ;
         /* Using cursor P02D72 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto, Short.valueOf(A2351LegSuelConSec), A2352LegSuelConCnt, A2353LegSuelConValU, A2354LegSuelConImp, A2355LegSuelConFor, Long.valueOf(A2356LegSuelConOrdE), A2358LegSuelLiqDLog});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo_sueldosConceptos");
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP15[0] = new_legajo_sueldo_conceptos.this.AV25error;
      Application.commitDataStores(context, remoteHandle, pr_default, "new_legajo_sueldo_conceptos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25error = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int4 = new byte[1] ;
      A2349LegSuelConcepto = "" ;
      A2352LegSuelConCnt = DecimalUtil.ZERO ;
      A2353LegSuelConValU = DecimalUtil.ZERO ;
      A2354LegSuelConImp = DecimalUtil.ZERO ;
      A2355LegSuelConFor = "" ;
      A2358LegSuelLiqDLog = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_legajo_sueldo_conceptos__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV24EmpTipoExp ;
   private byte AV26MostrarConcepto ;
   private byte GXv_int4[] ;
   private short AV18EmpCod ;
   private short AV16LegSuelSec ;
   private short AV13LegSuelConSec ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short A2351LegSuelConSec ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV17LegNumero ;
   private int GX_INS292 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV8LegSuelConOrdE ;
   private long A2356LegSuelConOrdE ;
   private java.math.BigDecimal AV12LegSuelConCnt ;
   private java.math.BigDecimal AV11LegSuelConValU ;
   private java.math.BigDecimal AV10LegSuelConImp ;
   private java.math.BigDecimal A2352LegSuelConCnt ;
   private java.math.BigDecimal A2353LegSuelConValU ;
   private java.math.BigDecimal A2354LegSuelConImp ;
   private String AV15LegSuelConcepto ;
   private String AV23sueldoConCodigo ;
   private String GXv_char3[] ;
   private String A2349LegSuelConcepto ;
   private String Gx_emsg ;
   private boolean AV21ConMostrarPos ;
   private boolean AV22ConErrorSiCero ;
   private boolean GXv_boolean2[] ;
   private boolean GXv_boolean1[] ;
   private String AV9LegSuelConFor ;
   private String AV20LegSuelLiqDLog ;
   private String A2355LegSuelConFor ;
   private String A2358LegSuelLiqDLog ;
   private String AV14LegSuelConDesc ;
   private String AV25error ;
   private String[] aP15 ;
   private IDataStoreProvider pr_default ;
}

final  class new_legajo_sueldo_conceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02D72", "SAVEPOINT gxupdate;INSERT INTO Legajo_sueldosConceptos(CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto, LegSuelConSec, LegSuelConCnt, LegSuelConValU, LegSuelConImp, LegSuelConFor, LegSuelConOrdE, LegSuelLiqDLog) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               return;
      }
   }

}

