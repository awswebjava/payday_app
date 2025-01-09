package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettemplaterecibo extends GXProcedure
{
   public gettemplaterecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettemplaterecibo.class ), "" );
   }

   public gettemplaterecibo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             short[] aP7 )
   {
      gettemplaterecibo.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        short[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             short[] aP7 ,
                             String[] aP8 )
   {
      gettemplaterecibo.this.AV13CliCod = aP0;
      gettemplaterecibo.this.AV12EmpCod = aP1;
      gettemplaterecibo.this.AV8TempRecSec = aP2;
      gettemplaterecibo.this.aP3 = aP3;
      gettemplaterecibo.this.aP4 = aP4;
      gettemplaterecibo.this.aP5 = aP5;
      gettemplaterecibo.this.aP6 = aP6;
      gettemplaterecibo.this.aP7 = aP7;
      gettemplaterecibo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00KO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV8TempRecSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A86TempRecSec = P00KO2_A86TempRecSec[0] ;
         A1EmpCod = P00KO2_A1EmpCod[0] ;
         A3CliCod = P00KO2_A3CliCod[0] ;
         A572TempRecHTML = P00KO2_A572TempRecHTML[0] ;
         A576TempRecHTMLBody = P00KO2_A576TempRecHTMLBody[0] ;
         A573TempRecHTMLRow = P00KO2_A573TempRecHTMLRow[0] ;
         A574TempRecTipoRecibo = P00KO2_A574TempRecTipoRecibo[0] ;
         A575TempRecPageSize = P00KO2_A575TempRecPageSize[0] ;
         A1139TempRecExplIIGG = P00KO2_A1139TempRecExplIIGG[0] ;
         AV11TempRecHTML = A572TempRecHTML ;
         AV15TempRecHTMLBody = A576TempRecHTMLBody ;
         AV9TempRecHTMLRow = A573TempRecHTMLRow ;
         AV10TempRecTipoRecibo = A574TempRecTipoRecibo ;
         AV14TempRecPageSize = A575TempRecPageSize ;
         AV16TempRecExplIIGG = A1139TempRecExplIIGG ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gettemplaterecibo.this.AV11TempRecHTML;
      this.aP4[0] = gettemplaterecibo.this.AV15TempRecHTMLBody;
      this.aP5[0] = gettemplaterecibo.this.AV9TempRecHTMLRow;
      this.aP6[0] = gettemplaterecibo.this.AV10TempRecTipoRecibo;
      this.aP7[0] = gettemplaterecibo.this.AV14TempRecPageSize;
      this.aP8[0] = gettemplaterecibo.this.AV16TempRecExplIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11TempRecHTML = "" ;
      AV15TempRecHTMLBody = "" ;
      AV9TempRecHTMLRow = "" ;
      AV10TempRecTipoRecibo = "" ;
      AV16TempRecExplIIGG = "" ;
      scmdbuf = "" ;
      P00KO2_A86TempRecSec = new short[1] ;
      P00KO2_A1EmpCod = new short[1] ;
      P00KO2_A3CliCod = new int[1] ;
      P00KO2_A572TempRecHTML = new String[] {""} ;
      P00KO2_A576TempRecHTMLBody = new String[] {""} ;
      P00KO2_A573TempRecHTMLRow = new String[] {""} ;
      P00KO2_A574TempRecTipoRecibo = new String[] {""} ;
      P00KO2_A575TempRecPageSize = new short[1] ;
      P00KO2_A1139TempRecExplIIGG = new String[] {""} ;
      A572TempRecHTML = "" ;
      A576TempRecHTMLBody = "" ;
      A573TempRecHTMLRow = "" ;
      A574TempRecTipoRecibo = "" ;
      A1139TempRecExplIIGG = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettemplaterecibo__default(),
         new Object[] {
             new Object[] {
            P00KO2_A86TempRecSec, P00KO2_A1EmpCod, P00KO2_A3CliCod, P00KO2_A572TempRecHTML, P00KO2_A576TempRecHTMLBody, P00KO2_A573TempRecHTMLRow, P00KO2_A574TempRecTipoRecibo, P00KO2_A575TempRecPageSize, P00KO2_A1139TempRecExplIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV8TempRecSec ;
   private short AV14TempRecPageSize ;
   private short A86TempRecSec ;
   private short A1EmpCod ;
   private short A575TempRecPageSize ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private String AV10TempRecTipoRecibo ;
   private String scmdbuf ;
   private String A574TempRecTipoRecibo ;
   private String AV11TempRecHTML ;
   private String AV15TempRecHTMLBody ;
   private String AV16TempRecExplIIGG ;
   private String A572TempRecHTML ;
   private String A576TempRecHTMLBody ;
   private String A1139TempRecExplIIGG ;
   private String AV9TempRecHTMLRow ;
   private String A573TempRecHTMLRow ;
   private String[] aP8 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private short[] aP7 ;
   private IDataStoreProvider pr_default ;
   private short[] P00KO2_A86TempRecSec ;
   private short[] P00KO2_A1EmpCod ;
   private int[] P00KO2_A3CliCod ;
   private String[] P00KO2_A572TempRecHTML ;
   private String[] P00KO2_A576TempRecHTMLBody ;
   private String[] P00KO2_A573TempRecHTMLRow ;
   private String[] P00KO2_A574TempRecTipoRecibo ;
   private short[] P00KO2_A575TempRecPageSize ;
   private String[] P00KO2_A1139TempRecExplIIGG ;
}

final  class gettemplaterecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KO2", "SELECT TempRecSec, EmpCod, CliCod, TempRecHTML, TempRecHTMLBody, TempRecHTMLRow, TempRecTipoRecibo, TempRecPageSize, TempRecExplIIGG FROM TemplateRecibo WHERE CliCod = ? and EmpCod = ? and TempRecSec = ? ORDER BY CliCod, EmpCod, TempRecSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

