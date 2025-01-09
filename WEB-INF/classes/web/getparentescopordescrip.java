package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparentescopordescrip extends GXProcedure
{
   public getparentescopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparentescopordescrip.class ), "" );
   }

   public getparentescopordescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getparentescopordescrip.this.aP3 = new boolean[] {false};
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
      getparentescopordescrip.this.AV8CliCod = aP0;
      getparentescopordescrip.this.AV9ParDescrip = aP1;
      getparentescopordescrip.this.aP2 = aP2;
      getparentescopordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01YU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ParDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2083ParDescripSinAc = P01YU2_A2083ParDescripSinAc[0] ;
         A3CliCod = P01YU2_A3CliCod[0] ;
         A30ParCod = P01YU2_A30ParCod[0] ;
         AV10ParCod = A30ParCod ;
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
      this.aP2[0] = getparentescopordescrip.this.AV10ParCod;
      this.aP3[0] = getparentescopordescrip.this.AV11existe;
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
      scmdbuf = "" ;
      P01YU2_A2083ParDescripSinAc = new String[] {""} ;
      P01YU2_A3CliCod = new int[1] ;
      P01YU2_A30ParCod = new String[] {""} ;
      A2083ParDescripSinAc = "" ;
      A30ParCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getparentescopordescrip__default(),
         new Object[] {
             new Object[] {
            P01YU2_A2083ParDescripSinAc, P01YU2_A3CliCod, P01YU2_A30ParCod
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
   private String A2083ParDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01YU2_A2083ParDescripSinAc ;
   private int[] P01YU2_A3CliCod ;
   private String[] P01YU2_A30ParCod ;
}

final  class getparentescopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YU2", "SELECT ParDescripSinAc, CliCod, ParCod FROM Parentesco WHERE (CliCod = ?) AND (ParDescripSinAc = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

