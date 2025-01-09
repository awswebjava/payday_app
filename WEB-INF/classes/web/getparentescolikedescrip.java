package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparentescolikedescrip extends GXProcedure
{
   public getparentescolikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparentescolikedescrip.class ), "" );
   }

   public getparentescolikedescrip( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              String[] aP3 )
   {
      getparentescolikedescrip.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getparentescolikedescrip.this.AV8CliCod = aP0;
      getparentescolikedescrip.this.AV9ParDescrip = aP1;
      getparentescolikedescrip.this.aP2 = aP2;
      getparentescolikedescrip.this.aP3 = aP3;
      getparentescolikedescrip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV9ParDescrip = GXutil.concat( GXutil.rtrim( AV9ParDescrip), "%", "") ;
      /* Using cursor P01YV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), lV9ParDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2083ParDescripSinAc = P01YV2_A2083ParDescripSinAc[0] ;
         A3CliCod = P01YV2_A3CliCod[0] ;
         A30ParCod = P01YV2_A30ParCod[0] ;
         AV10ParCod = A30ParCod ;
         AV12ParDescripSinAc = A2083ParDescripSinAc ;
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
      this.aP2[0] = getparentescolikedescrip.this.AV10ParCod;
      this.aP3[0] = getparentescolikedescrip.this.AV12ParDescripSinAc;
      this.aP4[0] = getparentescolikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ParCod = "" ;
      AV12ParDescripSinAc = "" ;
      lV9ParDescrip = "" ;
      scmdbuf = "" ;
      P01YV2_A2083ParDescripSinAc = new String[] {""} ;
      P01YV2_A3CliCod = new int[1] ;
      P01YV2_A30ParCod = new String[] {""} ;
      A2083ParDescripSinAc = "" ;
      A30ParCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getparentescolikedescrip__default(),
         new Object[] {
             new Object[] {
            P01YV2_A2083ParDescripSinAc, P01YV2_A3CliCod, P01YV2_A30ParCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ParCod ;
   private String scmdbuf ;
   private String A30ParCod ;
   private boolean AV11existe ;
   private String AV9ParDescrip ;
   private String AV12ParDescripSinAc ;
   private String lV9ParDescrip ;
   private String A2083ParDescripSinAc ;
   private boolean[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01YV2_A2083ParDescripSinAc ;
   private int[] P01YV2_A3CliCod ;
   private String[] P01YV2_A30ParCod ;
}

final  class getparentescolikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YV2", "SELECT ParDescripSinAc, CliCod, ParCod FROM Parentesco WHERE (CliCod = ?) AND (ParDescripSinAc like '%' || ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setVarchar(2, (String)parms[1], 30);
               return;
      }
   }

}

