package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconpadre extends GXProcedure
{
   public getconpadre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconpadre.class ), "" );
   }

   public getconpadre( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getconpadre.this.aP2 = new String[] {""};
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
      getconpadre.this.AV8CliCod = aP0;
      getconpadre.this.AV9ConCodigo = aP1;
      getconpadre.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01XV2_A26ConCodigo[0] ;
         A3CliCod = P01XV2_A3CliCod[0] ;
         A921ConPadre = P01XV2_A921ConPadre[0] ;
         n921ConPadre = P01XV2_n921ConPadre[0] ;
         AV10ConPadre = A921ConPadre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconpadre.this.AV10ConPadre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConPadre = "" ;
      scmdbuf = "" ;
      P01XV2_A26ConCodigo = new String[] {""} ;
      P01XV2_A3CliCod = new int[1] ;
      P01XV2_A921ConPadre = new String[] {""} ;
      P01XV2_n921ConPadre = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A921ConPadre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconpadre__default(),
         new Object[] {
             new Object[] {
            P01XV2_A26ConCodigo, P01XV2_A3CliCod, P01XV2_A921ConPadre, P01XV2_n921ConPadre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV10ConPadre ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A921ConPadre ;
   private boolean n921ConPadre ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01XV2_A26ConCodigo ;
   private int[] P01XV2_A3CliCod ;
   private String[] P01XV2_A921ConPadre ;
   private boolean[] P01XV2_n921ConPadre ;
}

final  class getconpadre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XV2", "SELECT ConCodigo, CliCod, ConPadre FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

