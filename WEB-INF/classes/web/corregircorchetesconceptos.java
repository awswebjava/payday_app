package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class corregircorchetesconceptos extends GXProcedure
{
   public corregircorchetesconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( corregircorchetesconceptos.class ), "" );
   }

   public corregircorchetesconceptos( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      corregircorchetesconceptos.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      /* Using cursor P01LA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01LA2_A3CliCod[0] ;
         A148ConFormula = P01LA2_A148ConFormula[0] ;
         n148ConFormula = P01LA2_n148ConFormula[0] ;
         A26ConCodigo = P01LA2_A26ConCodigo[0] ;
         AV13ConFormula = "" ;
         AV10i = (short)(1) ;
         AV11len = (short)(GXutil.len( A148ConFormula)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&len ", "")+GXutil.trim( GXutil.str( AV11len, 4, 0))) ;
         AV14abrio = false ;
         while ( AV10i <= AV11len )
         {
            if ( AV14abrio )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "abrio 1", "")) ;
               if ( GXutil.strcmp(GXutil.substring( A148ConFormula, AV10i, 1), "]") == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "abrio 2", "")) ;
                  AV14abrio = false ;
                  AV13ConFormula += "}" ;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "abrio 3", "")) ;
                  AV13ConFormula += GXutil.substring( A148ConFormula, AV10i, 1) ;
               }
               AV10i = (short)(AV10i+1) ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV10i, 4, 0))+GXutil.substring( A148ConFormula, AV10i, 3)) ;
               if ( GXutil.strcmp(GXutil.substring( GXutil.upper( A148ConFormula), AV10i, 3), httpContext.getMessage( "[C ", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "abrio 5", "")) ;
                  AV14abrio = true ;
                  AV13ConFormula += "{" ;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "abrio 6", "")) ;
                  AV13ConFormula += GXutil.substring( A148ConFormula, AV10i, 1) ;
               }
               AV10i = (short)(AV10i+1) ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &ConFormula ", "")+AV13ConFormula) ;
         A148ConFormula = AV13ConFormula ;
         n148ConFormula = false ;
         /* Using cursor P01LA3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "corregircorchetesconceptos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P01LA2_A3CliCod = new int[1] ;
      P01LA2_A148ConFormula = new String[] {""} ;
      P01LA2_n148ConFormula = new boolean[] {false} ;
      P01LA2_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      AV13ConFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.corregircorchetesconceptos__default(),
         new Object[] {
             new Object[] {
            P01LA2_A3CliCod, P01LA2_A148ConFormula, P01LA2_n148ConFormula, P01LA2_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      AV17Pgmname = "corregirCorchetesConceptos" ;
      /* GeneXus formulas. */
      AV17Pgmname = "corregirCorchetesConceptos" ;
      Gx_err = (short)(0) ;
   }

   private short AV10i ;
   private short AV11len ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n148ConFormula ;
   private boolean AV14abrio ;
   private String A148ConFormula ;
   private String AV13ConFormula ;
   private IDataStoreProvider pr_default ;
   private int[] P01LA2_A3CliCod ;
   private String[] P01LA2_A148ConFormula ;
   private boolean[] P01LA2_n148ConFormula ;
   private String[] P01LA2_A26ConCodigo ;
}

final  class corregircorchetesconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LA2", "SELECT CliCod, ConFormula, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01LA3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
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
               return;
            case 1 :
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

