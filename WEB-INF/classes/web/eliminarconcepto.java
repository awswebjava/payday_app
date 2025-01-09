package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarconcepto extends GXProcedure
{
   public eliminarconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarconcepto.class ), "" );
   }

   public eliminarconcepto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      eliminarconcepto.this.AV9CliCod = aP0;
      eliminarconcepto.this.AV8ConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P003X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P003X3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
      /* End optimized DELETE. */
      /* Using cursor P003X4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A26ConCodigo = P003X4_A26ConCodigo[0] ;
         A3CliCod = P003X4_A3CliCod[0] ;
         AV10auxConCodigo = A26ConCodigo ;
         /* Execute user subroutine: 'TIPOS LIQ' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(2);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'OPERANDOS' */
         S121 ();
         if ( returnInSub )
         {
            pr_default.close(2);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Using cursor P003X5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      cleanup();
   }

   public void S111( )
   {
      /* 'TIPOS LIQ' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P003X6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV9CliCod), AV10auxConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
      /* End optimized DELETE. */
   }

   public void S121( )
   {
      /* 'OPERANDOS' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P003X7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV9CliCod), AV10auxConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("concepto_operandos");
      /* End optimized DELETE. */
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarconcepto");
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
      P003X4_A26ConCodigo = new String[] {""} ;
      P003X4_A3CliCod = new int[1] ;
      A26ConCodigo = "" ;
      AV10auxConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarconcepto__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P003X4_A26ConCodigo, P003X4_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV10auxConCodigo ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private String[] P003X4_A26ConCodigo ;
   private int[] P003X4_A3CliCod ;
}

final  class eliminarconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P003X2", "DELETE FROM FormulaHistorico  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003X3", "DELETE FROM AgendaNovedades  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P003X4", "SELECT ConCodigo, CliCod FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P003X5", "SAVEPOINT gxupdate;DELETE FROM Concepto  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003X6", "DELETE FROM ConceptoTipoLiquidacion  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003X7", "DELETE FROM concepto_operandos  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

