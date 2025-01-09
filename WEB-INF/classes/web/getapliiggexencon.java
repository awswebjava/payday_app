package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliiggexencon extends GXProcedure
{
   public getapliiggexencon( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliiggexencon.class ), "" );
   }

   public getapliiggexencon( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getapliiggexencon.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getapliiggexencon.this.AV10CliCod = aP0;
      getapliiggexencon.this.AV8AplIIGG = aP1;
      getapliiggexencon.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01772 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8AplIIGG)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1112AplIIGG = P01772_A1112AplIIGG[0] ;
         A3CliCod = P01772_A3CliCod[0] ;
         A1117AplIIGGExenCon = P01772_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P01772_n1117AplIIGGExenCon[0] ;
         AV11AplIIGGExenCon = A1117AplIIGGExenCon ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getapliiggexencon.this.AV11AplIIGGExenCon;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11AplIIGGExenCon = "" ;
      scmdbuf = "" ;
      P01772_A1112AplIIGG = new short[1] ;
      P01772_A3CliCod = new int[1] ;
      P01772_A1117AplIIGGExenCon = new String[] {""} ;
      P01772_n1117AplIIGGExenCon = new boolean[] {false} ;
      A1117AplIIGGExenCon = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliiggexencon__default(),
         new Object[] {
             new Object[] {
            P01772_A1112AplIIGG, P01772_A3CliCod, P01772_A1117AplIIGGExenCon, P01772_n1117AplIIGGExenCon
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV11AplIIGGExenCon ;
   private String scmdbuf ;
   private String A1117AplIIGGExenCon ;
   private boolean n1117AplIIGGExenCon ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01772_A1112AplIIGG ;
   private int[] P01772_A3CliCod ;
   private String[] P01772_A1117AplIIGGExenCon ;
   private boolean[] P01772_n1117AplIIGGExenCon ;
}

final  class getapliiggexencon__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01772", "SELECT AplIIGG, CliCod, AplIIGGExenCon FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

