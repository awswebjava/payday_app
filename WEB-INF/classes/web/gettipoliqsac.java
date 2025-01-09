package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqsac extends GXProcedure
{
   public gettipoliqsac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqsac.class ), "" );
   }

   public gettipoliqsac( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      gettipoliqsac.this.aP2 = new boolean[] {false};
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
      gettipoliqsac.this.AV10CliCod = aP0;
      gettipoliqsac.this.AV8TLiqCod = aP1;
      gettipoliqsac.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01AX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P01AX2_A32TLiqCod[0] ;
         A3CliCod = P01AX2_A3CliCod[0] ;
         A1211TliqSAC = P01AX2_A1211TliqSAC[0] ;
         AV9TliqSAC = A1211TliqSAC ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoliqsac.this.AV9TliqSAC;
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
      P01AX2_A32TLiqCod = new String[] {""} ;
      P01AX2_A3CliCod = new int[1] ;
      P01AX2_A1211TliqSAC = new boolean[] {false} ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqsac__default(),
         new Object[] {
             new Object[] {
            P01AX2_A32TLiqCod, P01AX2_A3CliCod, P01AX2_A1211TliqSAC
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
   private boolean AV9TliqSAC ;
   private boolean A1211TliqSAC ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01AX2_A32TLiqCod ;
   private int[] P01AX2_A3CliCod ;
   private boolean[] P01AX2_A1211TliqSAC ;
}

final  class gettipoliqsac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AX2", "SELECT TLiqCod, CliCod, TliqSAC FROM TipoLiquidacion WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

