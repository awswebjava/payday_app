package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparentesco extends GXProcedure
{
   public getparentesco( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparentesco.class ), "" );
   }

   public getparentesco( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getparentesco.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getparentesco.this.AV11CliCod = aP0;
      getparentesco.this.AV8ParCod = aP1;
      getparentesco.this.aP2 = aP2;
      getparentesco.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01YT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8ParCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A30ParCod = P01YT2_A30ParCod[0] ;
         A3CliCod = P01YT2_A3CliCod[0] ;
         A313ParDescrip = P01YT2_A313ParDescrip[0] ;
         A2083ParDescripSinAc = P01YT2_A2083ParDescripSinAc[0] ;
         AV10ParDescrip = A313ParDescrip ;
         AV9ParDescripSinAc = A2083ParDescripSinAc ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getparentesco.this.AV10ParDescrip;
      this.aP3[0] = getparentesco.this.AV9ParDescripSinAc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ParDescrip = "" ;
      AV9ParDescripSinAc = "" ;
      scmdbuf = "" ;
      P01YT2_A30ParCod = new String[] {""} ;
      P01YT2_A3CliCod = new int[1] ;
      P01YT2_A313ParDescrip = new String[] {""} ;
      P01YT2_A2083ParDescripSinAc = new String[] {""} ;
      A30ParCod = "" ;
      A313ParDescrip = "" ;
      A2083ParDescripSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getparentesco__default(),
         new Object[] {
             new Object[] {
            P01YT2_A30ParCod, P01YT2_A3CliCod, P01YT2_A313ParDescrip, P01YT2_A2083ParDescripSinAc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV8ParCod ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String AV10ParDescrip ;
   private String AV9ParDescripSinAc ;
   private String A313ParDescrip ;
   private String A2083ParDescripSinAc ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01YT2_A30ParCod ;
   private int[] P01YT2_A3CliCod ;
   private String[] P01YT2_A313ParDescrip ;
   private String[] P01YT2_A2083ParDescripSinAc ;
}

final  class getparentesco__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YT2", "SELECT ParCod, CliCod, ParDescrip, ParDescripSinAc FROM Parentesco WHERE CliCod = ? and ParCod = ( ?) ORDER BY CliCod, ParCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

