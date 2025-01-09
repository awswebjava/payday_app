package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getbanco extends GXProcedure
{
   public getbanco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getbanco.class ), "" );
   }

   public getbanco( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getbanco.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getbanco.this.AV10CliCod = aP0;
      getbanco.this.AV8BanCod = aP1;
      getbanco.this.aP2 = aP2;
      getbanco.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8BanCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A7BanCod = P00AH2_A7BanCod[0] ;
         A3CliCod = P00AH2_A3CliCod[0] ;
         A117BanDescrip = P00AH2_A117BanDescrip[0] ;
         AV9BanDescrip = A117BanDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getbanco.this.AV9BanDescrip;
      this.aP3[0] = getbanco.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9BanDescrip = "" ;
      scmdbuf = "" ;
      P00AH2_A7BanCod = new String[] {""} ;
      P00AH2_A3CliCod = new int[1] ;
      P00AH2_A117BanDescrip = new String[] {""} ;
      A7BanCod = "" ;
      A117BanDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getbanco__default(),
         new Object[] {
             new Object[] {
            P00AH2_A7BanCod, P00AH2_A3CliCod, P00AH2_A117BanDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8BanCod ;
   private String scmdbuf ;
   private String A7BanCod ;
   private boolean AV11existe ;
   private String AV9BanDescrip ;
   private String A117BanDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AH2_A7BanCod ;
   private int[] P00AH2_A3CliCod ;
   private String[] P00AH2_A117BanDescrip ;
}

final  class getbanco__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AH2", "SELECT BanCod, CliCod, BanDescrip FROM Banco WHERE CliCod = ? and BanCod = ( ?) ORDER BY CliCod, BanCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(2, (String)parms[1], 6);
               return;
      }
   }

}

