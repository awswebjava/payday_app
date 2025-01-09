package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconceptoconvenio extends GXProcedure
{
   public newconceptoconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconceptoconvenio.class ), "" );
   }

   public newconceptoconvenio( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             String aP3 )
   {
      newconceptoconvenio.this.AV9CliCod = aP0;
      newconceptoconvenio.this.AV10ConCodigo = aP1;
      newconceptoconvenio.this.AV11ConConvePaiCod = aP2;
      newconceptoconvenio.this.AV8ConConveCodigo = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV10ConCodigo)+httpContext.getMessage( " &ConConvePaiCod ", "")+GXutil.trim( GXutil.str( AV11ConConvePaiCod, 4, 0))+httpContext.getMessage( " &ConConveCodigo ", "")+GXutil.trim( AV8ConConveCodigo)) ;
      n1645ConceptoConveCodigo = false ;
      n1644ConceptoPais = false ;
      /* Optimized UPDATE. */
      /* Using cursor P01362 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n1645ConceptoConveCodigo), AV8ConConveCodigo, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(AV11ConConvePaiCod), Integer.valueOf(AV9CliCod), AV10ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconceptoconvenio");
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
      A1645ConceptoConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconceptoconvenio__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV14Pgmname = "newConceptoConvenio" ;
      /* GeneXus formulas. */
      AV14Pgmname = "newConceptoConvenio" ;
      Gx_err = (short)(0) ;
   }

   private short AV11ConConvePaiCod ;
   private short A1644ConceptoPais ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10ConCodigo ;
   private String AV8ConConveCodigo ;
   private String AV14Pgmname ;
   private String A1645ConceptoConveCodigo ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1644ConceptoPais ;
   private IDataStoreProvider pr_default ;
}

final  class newconceptoconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01362", "UPDATE Concepto SET ConceptoConveCodigo=?, ConceptoPais=?  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               stmt.setInt(3, ((Number) parms[4]).intValue());
               stmt.setString(4, (String)parms[5], 10);
               return;
      }
   }

}

