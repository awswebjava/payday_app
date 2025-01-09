package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqacumula extends GXProcedure
{
   public gettipoliqacumula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqacumula.class ), "" );
   }

   public gettipoliqacumula( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      gettipoliqacumula.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      gettipoliqacumula.this.AV10CliCod = aP0;
      gettipoliqacumula.this.AV8TLiqCod = aP1;
      gettipoliqacumula.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P015W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P015W2_A32TLiqCod[0] ;
         A3CliCod = P015W2_A3CliCod[0] ;
         A1076TLiqAcuDiasTrab = P015W2_A1076TLiqAcuDiasTrab[0] ;
         AV9TLiqAcuDiasTrab = A1076TLiqAcuDiasTrab ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoliqacumula.this.AV9TLiqAcuDiasTrab;
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
      P015W2_A32TLiqCod = new String[] {""} ;
      P015W2_A3CliCod = new int[1] ;
      P015W2_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqacumula__default(),
         new Object[] {
             new Object[] {
            P015W2_A32TLiqCod, P015W2_A3CliCod, P015W2_A1076TLiqAcuDiasTrab
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private boolean AV9TLiqAcuDiasTrab ;
   private boolean A1076TLiqAcuDiasTrab ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P015W2_A32TLiqCod ;
   private int[] P015W2_A3CliCod ;
   private boolean[] P015W2_A1076TLiqAcuDiasTrab ;
}

final  class gettipoliqacumula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P015W2", "SELECT TLiqCod, CliCod, TLiqAcuDiasTrab FROM TipoLiquidacion WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

