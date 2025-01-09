package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlugpagpordescrip extends GXProcedure
{
   public getlugpagpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlugpagpordescrip.class ), "" );
   }

   public getlugpagpordescrip( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getlugpagpordescrip.this.aP3 = new boolean[] {false};
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
      getlugpagpordescrip.this.AV10CliCod = aP0;
      getlugpagpordescrip.this.AV9LpgDescri = aP1;
      getlugpagpordescrip.this.aP2 = aP2;
      getlugpagpordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9LpgDescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A677LpgDescriSinAc = P00LS2_A677LpgDescriSinAc[0] ;
         A3CliCod = P00LS2_A3CliCod[0] ;
         A10LpgCodigo = P00LS2_A10LpgCodigo[0] ;
         AV8LpgCodigo = A10LpgCodigo ;
         AV11existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getlugpagpordescrip.this.AV8LpgCodigo;
      this.aP3[0] = getlugpagpordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LpgCodigo = "" ;
      scmdbuf = "" ;
      P00LS2_A677LpgDescriSinAc = new String[] {""} ;
      P00LS2_A3CliCod = new int[1] ;
      P00LS2_A10LpgCodigo = new String[] {""} ;
      A677LpgDescriSinAc = "" ;
      A10LpgCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlugpagpordescrip__default(),
         new Object[] {
             new Object[] {
            P00LS2_A677LpgDescriSinAc, P00LS2_A3CliCod, P00LS2_A10LpgCodigo
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
   private String A677LpgDescriSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LS2_A677LpgDescriSinAc ;
   private int[] P00LS2_A3CliCod ;
   private String[] P00LS2_A10LpgCodigo ;
}

final  class getlugpagpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LS2", "SELECT LpgDescriSinAc, CliCod, LpgCodigo FROM LugardePago WHERE (CliCod = ?) AND (LpgDescriSinAc = ( ?)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

