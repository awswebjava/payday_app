package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getreleasedtchar extends GXProcedure
{
   public getreleasedtchar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getreleasedtchar.class ), "" );
   }

   public getreleasedtchar( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int aP1 )
   {
      getreleasedtchar.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String[] aP2 )
   {
      getreleasedtchar.this.AV9CliCod = aP0;
      getreleasedtchar.this.AV10CliRelSec = aP1;
      getreleasedtchar.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13GXLvl2 = (byte)(0) ;
      /* Using cursor P01S72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Integer.valueOf(AV10CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1885CliRelSec = P01S72_A1885CliRelSec[0] ;
         A3CliCod = P01S72_A3CliCod[0] ;
         A1880CliReDTChar = P01S72_A1880CliReDTChar[0] ;
         AV13GXLvl2 = (byte)(1) ;
         AV8CliReDTChar = A1880CliReDTChar ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV13GXLvl2 == 0 )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getreleasedtchar.this.AV8CliReDTChar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CliReDTChar = "" ;
      scmdbuf = "" ;
      P01S72_A1885CliRelSec = new int[1] ;
      P01S72_A3CliCod = new int[1] ;
      P01S72_A1880CliReDTChar = new String[] {""} ;
      A1880CliReDTChar = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getreleasedtchar__default(),
         new Object[] {
             new Object[] {
            P01S72_A1885CliRelSec, P01S72_A3CliCod, P01S72_A1880CliReDTChar
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl2 ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10CliRelSec ;
   private int A1885CliRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV8CliReDTChar ;
   private String A1880CliReDTChar ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01S72_A1885CliRelSec ;
   private int[] P01S72_A3CliCod ;
   private String[] P01S72_A1880CliReDTChar ;
}

final  class getreleasedtchar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01S72", "SELECT CliRelSec, CliCod, CliReDTChar FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

