package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esconceptosdefault extends GXProcedure
{
   public esconceptosdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esconceptosdefault.class ), "" );
   }

   public esconceptosdefault( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      esconceptosdefault.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      esconceptosdefault.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10clicod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      esconceptosdefault.this.GXt_int1 = GXv_int2[0] ;
      AV10clicod = GXt_int1 ;
      /* Using cursor P000V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10clicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A747ClienteSistema = P000V2_A747ClienteSistema[0] ;
         A3CliCod = P000V2_A3CliCod[0] ;
         AV9esSistemaConceptosDefault = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = esconceptosdefault.this.AV9esSistemaConceptosDefault;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P000V2_A747ClienteSistema = new boolean[] {false} ;
      P000V2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esconceptosdefault__default(),
         new Object[] {
             new Object[] {
            P000V2_A747ClienteSistema, P000V2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10clicod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9esSistemaConceptosDefault ;
   private boolean A747ClienteSistema ;
   private boolean[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P000V2_A747ClienteSistema ;
   private int[] P000V2_A3CliCod ;
}

final  class esconceptosdefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000V2", "SELECT ClienteSistema, CliCod FROM Cliente WHERE (CliCod = ?) AND (ClienteSistema = TRUE) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
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
               return;
      }
   }

}

