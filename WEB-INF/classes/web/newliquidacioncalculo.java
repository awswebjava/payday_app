package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliquidacioncalculo extends GXProcedure
{
   public newliquidacioncalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliquidacioncalculo.class ), "" );
   }

   public newliquidacioncalculo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 )
   {
      newliquidacioncalculo.this.AV10CliCod = aP0;
      newliquidacioncalculo.this.AV11EmpCod = aP1;
      newliquidacioncalculo.this.AV12LiqNro = aP2;
      newliquidacioncalculo.this.AV9LegNumero = aP3;
      newliquidacioncalculo.this.AV13LiqDOpeOrig = aP4;
      newliquidacioncalculo.this.AV14LiqDOpeLog = aP5;
      newliquidacioncalculo.this.AV8LiqdOpeRes = aP6;
      newliquidacioncalculo.this.AV15LiqdOpeCant = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE liquidacionLegajoCalculos

      */
      A3CliCod = AV10CliCod ;
      A1EmpCod = AV11EmpCod ;
      A31LiqNro = AV12LiqNro ;
      A6LegNumero = AV9LegNumero ;
      A1035LiqDOpeOrig = AV13LiqDOpeOrig ;
      A2074LiqDOpeLog = AV14LiqDOpeLog ;
      A2075LiqdOpeRes = AV8LiqdOpeRes ;
      A2076LiqdOpeCant = AV15LiqdOpeCant ;
      /* Using cursor P01YA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A1035LiqDOpeOrig, A2074LiqDOpeLog, A2075LiqdOpeRes, A2076LiqdOpeCant});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacionLegajoCalculos");
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
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1035LiqDOpeOrig = "" ;
      A2074LiqDOpeLog = "" ;
      A2075LiqdOpeRes = DecimalUtil.ZERO ;
      A2076LiqdOpeCant = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newliquidacioncalculo__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV9LegNumero ;
   private int GX_INS260 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV8LiqdOpeRes ;
   private java.math.BigDecimal AV15LiqdOpeCant ;
   private java.math.BigDecimal A2075LiqdOpeRes ;
   private java.math.BigDecimal A2076LiqdOpeCant ;
   private String AV13LiqDOpeOrig ;
   private String A1035LiqDOpeOrig ;
   private String Gx_emsg ;
   private String AV14LiqDOpeLog ;
   private String A2074LiqDOpeLog ;
   private IDataStoreProvider pr_default ;
}

final  class newliquidacioncalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01YA2", "SAVEPOINT gxupdate;INSERT INTO liquidacionLegajoCalculos(CliCod, EmpCod, LiqNro, LegNumero, LiqDOpeOrig, LiqDOpeLog, LiqdOpeRes, LiqdOpeCant) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 100);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               return;
      }
   }

}

