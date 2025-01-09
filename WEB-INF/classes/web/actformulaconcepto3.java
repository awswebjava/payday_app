package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actformulaconcepto3 extends GXProcedure
{
   public actformulaconcepto3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actformulaconcepto3.class ), "" );
   }

   public actformulaconcepto3( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      actformulaconcepto3.this.AV10CliCod = aP0;
      actformulaconcepto3.this.AV8ConCodigo = aP1;
      actformulaconcepto3.this.AV9ConFormula = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n148ConFormula = false ;
      /* Optimized UPDATE. */
      /* Using cursor P00RF2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n148ConFormula), AV9ConFormula, Integer.valueOf(AV10CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actformulaconcepto3");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A148ConFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actformulaconcepto3__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8ConCodigo ;
   private boolean n148ConFormula ;
   private String AV9ConFormula ;
   private String A148ConFormula ;
   private IDataStoreProvider pr_default ;
}

final  class actformulaconcepto3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00RF2", "UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
      }
   }

}

