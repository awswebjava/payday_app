package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayconceptosafip extends GXProcedure
{
   public hayconceptosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayconceptosafip.class ), "" );
   }

   public hayconceptosafip( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      hayconceptosafip.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      hayconceptosafip.this.AV9CliCod = aP0;
      hayconceptosafip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00GX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00GX2_A3CliCod[0] ;
         A73ConCodPropio = P00GX2_A73ConCodPropio[0] ;
         AV8hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = hayconceptosafip.this.AV8hay;
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
      P00GX2_A3CliCod = new int[1] ;
      P00GX2_A73ConCodPropio = new String[] {""} ;
      A73ConCodPropio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayconceptosafip__default(),
         new Object[] {
             new Object[] {
            P00GX2_A3CliCod, P00GX2_A73ConCodPropio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A73ConCodPropio ;
   private boolean AV8hay ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00GX2_A3CliCod ;
   private String[] P00GX2_A73ConCodPropio ;
}

final  class hayconceptosafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GX2", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE CliCod = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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

