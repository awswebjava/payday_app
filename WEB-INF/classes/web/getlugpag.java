package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlugpag extends GXProcedure
{
   public getlugpag( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlugpag.class ), "" );
   }

   public getlugpag( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getlugpag.this.aP3 = new boolean[] {false};
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
      getlugpag.this.AV10CliCod = aP0;
      getlugpag.this.AV8LpgCodigo = aP1;
      getlugpag.this.aP2 = aP2;
      getlugpag.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P009Z2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8LpgCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A10LpgCodigo = P009Z2_A10LpgCodigo[0] ;
         A3CliCod = P009Z2_A3CliCod[0] ;
         A291LpgDescri = P009Z2_A291LpgDescri[0] ;
         AV9LpgDescri = A291LpgDescri ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getlugpag.this.AV9LpgDescri;
      this.aP3[0] = getlugpag.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LpgDescri = "" ;
      scmdbuf = "" ;
      P009Z2_A10LpgCodigo = new String[] {""} ;
      P009Z2_A3CliCod = new int[1] ;
      P009Z2_A291LpgDescri = new String[] {""} ;
      A10LpgCodigo = "" ;
      A291LpgDescri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlugpag__default(),
         new Object[] {
             new Object[] {
            P009Z2_A10LpgCodigo, P009Z2_A3CliCod, P009Z2_A291LpgDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8LpgCodigo ;
   private String scmdbuf ;
   private String A10LpgCodigo ;
   private boolean AV11existe ;
   private String AV9LpgDescri ;
   private String A291LpgDescri ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P009Z2_A10LpgCodigo ;
   private int[] P009Z2_A3CliCod ;
   private String[] P009Z2_A291LpgDescri ;
}

final  class getlugpag__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009Z2", "SELECT LpgCodigo, CliCod, LpgDescri FROM LugardePago WHERE CliCod = ? and LpgCodigo = ( ?) ORDER BY CliCod, LpgCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

