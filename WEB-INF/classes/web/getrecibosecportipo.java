package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrecibosecportipo extends GXProcedure
{
   public getrecibosecportipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrecibosecportipo.class ), "" );
   }

   public getrecibosecportipo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            String aP2 )
   {
      getrecibosecportipo.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             short[] aP3 )
   {
      getrecibosecportipo.this.AV10CliCod = aP0;
      getrecibosecportipo.this.AV9EmpCod = aP1;
      getrecibosecportipo.this.AV8TempRecTipoRecibo = aP2;
      getrecibosecportipo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00TR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), AV8TempRecTipoRecibo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A574TempRecTipoRecibo = P00TR2_A574TempRecTipoRecibo[0] ;
         A1EmpCod = P00TR2_A1EmpCod[0] ;
         A3CliCod = P00TR2_A3CliCod[0] ;
         A86TempRecSec = P00TR2_A86TempRecSec[0] ;
         AV11TempRecSec = A86TempRecSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getrecibosecportipo.this.AV11TempRecSec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00TR2_A574TempRecTipoRecibo = new String[] {""} ;
      P00TR2_A1EmpCod = new short[1] ;
      P00TR2_A3CliCod = new int[1] ;
      P00TR2_A86TempRecSec = new short[1] ;
      A574TempRecTipoRecibo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrecibosecportipo__default(),
         new Object[] {
             new Object[] {
            P00TR2_A574TempRecTipoRecibo, P00TR2_A1EmpCod, P00TR2_A3CliCod, P00TR2_A86TempRecSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11TempRecSec ;
   private short A1EmpCod ;
   private short A86TempRecSec ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8TempRecTipoRecibo ;
   private String scmdbuf ;
   private String A574TempRecTipoRecibo ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00TR2_A574TempRecTipoRecibo ;
   private short[] P00TR2_A1EmpCod ;
   private int[] P00TR2_A3CliCod ;
   private short[] P00TR2_A86TempRecSec ;
}

final  class getrecibosecportipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00TR2", "SELECT TempRecTipoRecibo, EmpCod, CliCod, TempRecSec FROM TemplateRecibo WHERE (CliCod = ? and EmpCod = ?) AND (TempRecTipoRecibo = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

