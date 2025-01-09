package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getbancolikedescrip extends GXProcedure
{
   public getbancolikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getbancolikedescrip.class ), "" );
   }

   public getbancolikedescrip( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getbancolikedescrip.this.aP3 = new boolean[] {false};
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
      getbancolikedescrip.this.AV10CliCod = aP0;
      getbancolikedescrip.this.AV9BanDescrip = aP1;
      getbancolikedescrip.this.aP2 = aP2;
      getbancolikedescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV9BanDescrip = GXutil.concat( GXutil.rtrim( AV9BanDescrip), "%", "") ;
      /* Using cursor P00M72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), lV9BanDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A679BanDescripSinAc = P00M72_A679BanDescripSinAc[0] ;
         A3CliCod = P00M72_A3CliCod[0] ;
         A7BanCod = P00M72_A7BanCod[0] ;
         AV8BanCod = A7BanCod ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getbancolikedescrip.this.AV8BanCod;
      this.aP3[0] = getbancolikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8BanCod = "" ;
      lV9BanDescrip = "" ;
      scmdbuf = "" ;
      P00M72_A679BanDescripSinAc = new String[] {""} ;
      P00M72_A3CliCod = new int[1] ;
      P00M72_A7BanCod = new String[] {""} ;
      A679BanDescripSinAc = "" ;
      A7BanCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getbancolikedescrip__default(),
         new Object[] {
             new Object[] {
            P00M72_A679BanDescripSinAc, P00M72_A3CliCod, P00M72_A7BanCod
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
   private String lV9BanDescrip ;
   private String A679BanDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M72_A679BanDescripSinAc ;
   private int[] P00M72_A3CliCod ;
   private String[] P00M72_A7BanCod ;
}

final  class getbancolikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M72", "SELECT BanDescripSinAc, CliCod, BanCod FROM Banco WHERE (CliCod = ?) AND (BanDescripSinAc like '%' || ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
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
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

