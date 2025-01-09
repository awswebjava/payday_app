package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqdesc extends GXProcedure
{
   public gettipoliqdesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqdesc.class ), "" );
   }

   public gettipoliqdesc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      gettipoliqdesc.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      gettipoliqdesc.this.AV8CliCod = aP0;
      gettipoliqdesc.this.AV10TLiqCod = aP1;
      gettipoliqdesc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00PA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV10TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P00PA2_A32TLiqCod[0] ;
         A3CliCod = P00PA2_A3CliCod[0] ;
         A340TliqDesc = P00PA2_A340TliqDesc[0] ;
         AV9TliqDesc = A340TliqDesc ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoliqdesc.this.AV9TliqDesc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9TliqDesc = "" ;
      scmdbuf = "" ;
      P00PA2_A32TLiqCod = new String[] {""} ;
      P00PA2_A3CliCod = new int[1] ;
      P00PA2_A340TliqDesc = new String[] {""} ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqdesc__default(),
         new Object[] {
             new Object[] {
            P00PA2_A32TLiqCod, P00PA2_A3CliCod, P00PA2_A340TliqDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV9TliqDesc ;
   private String A340TliqDesc ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00PA2_A32TLiqCod ;
   private int[] P00PA2_A3CliCod ;
   private String[] P00PA2_A340TliqDesc ;
}

final  class gettipoliqdesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00PA2", "SELECT TLiqCod, CliCod, TliqDesc FROM TipoLiquidacion WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

