package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class desasignarconsumoslicegr extends GXProcedure
{
   public desasignarconsumoslicegr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( desasignarconsumoslicegr.class ), "" );
   }

   public desasignarconsumoslicegr( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 )
   {
      desasignarconsumoslicegr.this.AV10CliCod = aP0;
      desasignarconsumoslicegr.this.AV11EmpCod = aP1;
      desasignarconsumoslicegr.this.AV9LiqNro = aP2;
      desasignarconsumoslicegr.this.AV8LegNumero = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "cli ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))) ;
      AV15GXLvl3 = (byte)(0) ;
      /* Optimized DELETE. */
      /* Using cursor P02CJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV8LegNumero)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV15GXLvl3 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
      /* End optimized DELETE. */
      if ( AV15GXLvl3 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "none 1", "")) ;
      }
      AV16GXLvl14 = (byte)(0) ;
      /* Optimized DELETE. */
      /* Using cursor P02CJ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV8LegNumero)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         AV16GXLvl14 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
      /* End optimized DELETE. */
      if ( AV16GXLvl14 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "none 2", "")) ;
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
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.desasignarconsumoslicegr__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV14Pgmname = "desasignarConsumosLicEgr" ;
      /* GeneXus formulas. */
      AV14Pgmname = "desasignarConsumosLicEgr" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl3 ;
   private byte AV16GXLvl14 ;
   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LiqNro ;
   private int AV8LegNumero ;
   private String AV14Pgmname ;
   private IDataStoreProvider pr_default ;
}

final  class desasignarconsumoslicegr__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02CJ2", "DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? and EmpCod = ? and LegCuLAprLiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02CJ3", "DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? and EmpCod = ? and LegCulConsLiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

