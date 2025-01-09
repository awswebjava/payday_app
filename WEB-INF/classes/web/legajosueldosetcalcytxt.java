package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajosueldosetcalcytxt extends GXProcedure
{
   public legajosueldosetcalcytxt( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajosueldosetcalcytxt.class ), "" );
   }

   public legajosueldosetcalcytxt( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        java.math.BigDecimal aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             java.math.BigDecimal aP4 ,
                             String aP5 )
   {
      legajosueldosetcalcytxt.this.AV11CliCod = aP0;
      legajosueldosetcalcytxt.this.AV10EmpCod = aP1;
      legajosueldosetcalcytxt.this.AV9LegNumero = aP2;
      legajosueldosetcalcytxt.this.AV8LegSuelSec = aP3;
      legajosueldosetcalcytxt.this.AV12LegSuelCalc = aP4;
      legajosueldosetcalcytxt.this.AV13LegSuelLog = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16GXLvl1 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P02DE2 */
      pr_default.execute(0, new Object[] {AV13LegSuelLog, AV12LegSuelCalc, Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero), Short.valueOf(AV8LegSuelSec)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV16GXLvl1 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
      /* End optimized UPDATE. */
      if ( AV16GXLvl1 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV17Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "legajosueldosetcalcytxt");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2348LegSuelLog = "" ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      AV17Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajosueldosetcalcytxt__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV17Pgmname = "legajoSueldoSetCalcYTxt" ;
      /* GeneXus formulas. */
      AV17Pgmname = "legajoSueldoSetCalcYTxt" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16GXLvl1 ;
   private short AV10EmpCod ;
   private short AV8LegSuelSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private java.math.BigDecimal AV12LegSuelCalc ;
   private java.math.BigDecimal A2347LegSuelCalc ;
   private String AV17Pgmname ;
   private String AV13LegSuelLog ;
   private String A2348LegSuelLog ;
   private IDataStoreProvider pr_default ;
}

final  class legajosueldosetcalcytxt__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02DE2", "UPDATE legajo_sueldos SET LegSuelLog=?, LegSuelCalc=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

