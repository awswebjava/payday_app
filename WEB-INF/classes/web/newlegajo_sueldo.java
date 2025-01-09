package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newlegajo_sueldo extends GXProcedure
{
   public newlegajo_sueldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newlegajo_sueldo.class ), "" );
   }

   public newlegajo_sueldo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal aP4 ,
                             String aP5 )
   {
      newlegajo_sueldo.this.AV8CliCod = aP0;
      newlegajo_sueldo.this.AV9EmpCod = aP1;
      newlegajo_sueldo.this.AV10LegNumero = aP2;
      newlegajo_sueldo.this.AV12LegSuelFecha = aP3;
      newlegajo_sueldo.this.AV13LegSuelImporte = aP4;
      newlegajo_sueldo.this.AV14LegSuelTipo = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV23Pgmname, "1") ;
      GXt_char1 = AV18mensualTLiqCod ;
      GXt_char2 = AV18mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      newlegajo_sueldo.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      newlegajo_sueldo.this.GXt_char1 = GXv_char4[0] ;
      AV18mensualTLiqCod = GXt_char1 ;
      AV24GXLvl3 = (byte)(0) ;
      /* Using cursor P018H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12LegSuelFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1136LegSuelFecha = P018H2_A1136LegSuelFecha[0] ;
         A6LegNumero = P018H2_A6LegNumero[0] ;
         A1EmpCod = P018H2_A1EmpCod[0] ;
         A3CliCod = P018H2_A3CliCod[0] ;
         A1137LegSuelImporte = P018H2_A1137LegSuelImporte[0] ;
         A1135LegSuelSec = P018H2_A1135LegSuelSec[0] ;
         AV24GXLvl3 = (byte)(1) ;
         A1137LegSuelImporte = AV13LegSuelImporte ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV23Pgmname, "2") ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P018H3 */
         pr_default.execute(1, new Object[] {A1137LegSuelImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         if (true) break;
         /* Using cursor P018H4 */
         pr_default.execute(2, new Object[] {A1137LegSuelImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV24GXLvl3 == 0 )
      {
         /*
            INSERT RECORD ON TABLE legajo_sueldos

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV9EmpCod ;
         A6LegNumero = AV10LegNumero ;
         GXt_int5 = A1135LegSuelSec ;
         GXv_int6[0] = GXt_int5 ;
         new web.ultimolegajosuelsec(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_int6) ;
         newlegajo_sueldo.this.GXt_int5 = GXv_int6[0] ;
         A1135LegSuelSec = GXt_int5 ;
         A1136LegSuelFecha = AV12LegSuelFecha ;
         A1137LegSuelImporte = AV13LegSuelImporte ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV23Pgmname, httpContext.getMessage( "LegSuelSec ", "")+GXutil.trim( GXutil.str( A1135LegSuelSec, 4, 0))+httpContext.getMessage( " LegSuelFecha ", "")+GXutil.trim( localUtil.dtoc( A1136LegSuelFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " LegSuelImporte ", "")+GXutil.trim( GXutil.str( A1137LegSuelImporte, 14, 2))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV23Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
         A2344LegSuelTipo = AV14LegSuelTipo ;
         n2344LegSuelTipo = false ;
         GXv_decimal7[0] = AV15LegSuelCalc ;
         GXv_char4[0] = AV16LegSuelLog ;
         new web.leyendaaclaracionsueldo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV14LegSuelTipo, AV12LegSuelFecha, (short)(0), AV13LegSuelImporte, false, false, "", false, false, GXv_decimal7, GXv_char4) ;
         newlegajo_sueldo.this.AV15LegSuelCalc = GXv_decimal7[0] ;
         newlegajo_sueldo.this.AV16LegSuelLog = GXv_char4[0] ;
         A2347LegSuelCalc = AV15LegSuelCalc ;
         A2348LegSuelLog = AV16LegSuelLog ;
         GXv_boolean8[0] = AV17LegSuelBasica ;
         new web.determinalegsuelbasica(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV10LegNumero, AV18mensualTLiqCod, AV12LegSuelFecha, (short)(0), "", GXv_boolean8) ;
         newlegajo_sueldo.this.AV17LegSuelBasica = GXv_boolean8[0] ;
         A2357LegSuelBasica = AV17LegSuelBasica ;
         A2359LegSuelCalCom = false ;
         GXv_date9[0] = AV19LegSuelVto ;
         new web.calculafechavtosuelprecalc(remoteHandle, context).execute( AV8CliCod, AV12LegSuelFecha, GXv_date9) ;
         newlegajo_sueldo.this.AV19LegSuelVto = GXv_date9[0] ;
         A2379LegSuelVto = AV19LegSuelVto ;
         /* Using cursor P018H5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A1136LegSuelFecha, A1137LegSuelImporte, Boolean.valueOf(n2344LegSuelTipo), A2344LegSuelTipo, A2347LegSuelCalc, A2348LegSuelLog, Boolean.valueOf(A2357LegSuelBasica), Boolean.valueOf(A2359LegSuelCalCom), A2379LegSuelVto});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         if ( (pr_default.getStatus(3) == 1) )
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
         AV11LegSuelSec = A1135LegSuelSec ;
         GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = "" ;
         new web.leyendaaclaracionsueldo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV14LegSuelTipo, AV12LegSuelFecha, AV11LegSuelSec, AV13LegSuelImporte, false, false, "", false, false, GXv_decimal7, GXv_char4) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23Pgmname = "" ;
      AV18mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P018H2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P018H2_A6LegNumero = new int[1] ;
      P018H2_A1EmpCod = new short[1] ;
      P018H2_A3CliCod = new int[1] ;
      P018H2_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018H2_A1135LegSuelSec = new short[1] ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      GXv_int6 = new short[1] ;
      A2344LegSuelTipo = "" ;
      AV15LegSuelCalc = DecimalUtil.ZERO ;
      AV16LegSuelLog = "" ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      A2348LegSuelLog = "" ;
      GXv_boolean8 = new boolean[1] ;
      AV19LegSuelVto = GXutil.nullDate() ;
      GXv_date9 = new java.util.Date[1] ;
      A2379LegSuelVto = GXutil.nullDate() ;
      Gx_emsg = "" ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newlegajo_sueldo__default(),
         new Object[] {
             new Object[] {
            P018H2_A1136LegSuelFecha, P018H2_A6LegNumero, P018H2_A1EmpCod, P018H2_A3CliCod, P018H2_A1137LegSuelImporte, P018H2_A1135LegSuelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV23Pgmname = "newlegajo_sueldo" ;
      /* GeneXus formulas. */
      AV23Pgmname = "newlegajo_sueldo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24GXLvl3 ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short GXt_int5 ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private short AV11LegSuelSec ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int GX_INS129 ;
   private java.math.BigDecimal AV13LegSuelImporte ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private java.math.BigDecimal AV15LegSuelCalc ;
   private java.math.BigDecimal A2347LegSuelCalc ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV14LegSuelTipo ;
   private String AV23Pgmname ;
   private String AV18mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A2344LegSuelTipo ;
   private String Gx_emsg ;
   private String GXv_char4[] ;
   private java.util.Date AV12LegSuelFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private java.util.Date AV19LegSuelVto ;
   private java.util.Date GXv_date9[] ;
   private java.util.Date A2379LegSuelVto ;
   private boolean n2344LegSuelTipo ;
   private boolean AV17LegSuelBasica ;
   private boolean GXv_boolean8[] ;
   private boolean A2357LegSuelBasica ;
   private boolean A2359LegSuelCalCom ;
   private String AV16LegSuelLog ;
   private String A2348LegSuelLog ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P018H2_A1136LegSuelFecha ;
   private int[] P018H2_A6LegNumero ;
   private short[] P018H2_A1EmpCod ;
   private int[] P018H2_A3CliCod ;
   private java.math.BigDecimal[] P018H2_A1137LegSuelImporte ;
   private short[] P018H2_A1135LegSuelSec ;
}

final  class newlegajo_sueldo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018H2", "SELECT LegSuelFecha, LegNumero, EmpCod, CliCod, LegSuelImporte, LegSuelSec FROM legajo_sueldos WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegSuelFecha = ?) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1 FOR UPDATE OF legajo_sueldos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P018H3", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelImporte=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P018H4", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelImporte=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P018H5", "SAVEPOINT gxupdate;INSERT INTO legajo_sueldos(CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog, LegSuelBasica, LegSuelCalCom, LegSuelVto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               stmt.setBoolean(10, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[11]).booleanValue());
               stmt.setDate(12, (java.util.Date)parms[12]);
               return;
      }
   }

}

