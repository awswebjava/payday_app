package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getesquemadefault extends GXProcedure
{
   public getesquemadefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getesquemadefault.class ), "" );
   }

   public getesquemadefault( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getesquemadefault.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getesquemadefault.this.AV8CliCod = aP0;
      getesquemadefault.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2429CliConveEsquemaEs = P02LV2_A2429CliConveEsquemaEs[0] ;
         A3CliCod = P02LV2_A3CliCod[0] ;
         A1565CliConvenio = P02LV2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02LV2_A1564CliPaiConve[0] ;
         AV9CliConvenio = A1565CliConvenio ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getesquemadefault.this.AV9CliConvenio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CliConvenio = "" ;
      scmdbuf = "" ;
      P02LV2_A2429CliConveEsquemaEs = new boolean[] {false} ;
      P02LV2_A3CliCod = new int[1] ;
      P02LV2_A1565CliConvenio = new String[] {""} ;
      P02LV2_A1564CliPaiConve = new short[1] ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getesquemadefault__default(),
         new Object[] {
             new Object[] {
            P02LV2_A2429CliConveEsquemaEs, P02LV2_A3CliCod, P02LV2_A1565CliConvenio, P02LV2_A1564CliPaiConve
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private boolean A2429CliConveEsquemaEs ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P02LV2_A2429CliConveEsquemaEs ;
   private int[] P02LV2_A3CliCod ;
   private String[] P02LV2_A1565CliConvenio ;
   private short[] P02LV2_A1564CliPaiConve ;
}

final  class getesquemadefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LV2", "SELECT CliConveEsquemaEs, CliCod, CliConvenio, CliPaiConve FROM ClienteConvenios WHERE (CliCod = ?) AND (CliConveEsquemaEs = TRUE) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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

