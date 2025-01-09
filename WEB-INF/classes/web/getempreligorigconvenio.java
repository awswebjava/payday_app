package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempreligorigconvenio extends GXProcedure
{
   public getempreligorigconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempreligorigconvenio.class ), "" );
   }

   public getempreligorigconvenio( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String aP4 ,
                              short[] aP5 ,
                              boolean[] aP6 )
   {
      getempreligorigconvenio.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        short[] aP5 ,
                        boolean[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             short[] aP5 ,
                             boolean[] aP6 ,
                             boolean[] aP7 )
   {
      getempreligorigconvenio.this.AV9CliCod = aP0;
      getempreligorigconvenio.this.AV15EmpCod = aP1;
      getempreligorigconvenio.this.AV8EmpReligion = aP2;
      getempreligorigconvenio.this.AV11EmpOrigen = aP3;
      getempreligorigconvenio.this.AV13EmpConvenio = aP4;
      getempreligorigconvenio.this.aP5 = aP5;
      getempreligorigconvenio.this.aP6 = aP6;
      getempreligorigconvenio.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV8EmpReligion)==0) )
      {
         /* Using cursor P01BG2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV15EmpCod), AV8EmpReligion});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1237EmpReligion = P01BG2_A1237EmpReligion[0] ;
            A1EmpCod = P01BG2_A1EmpCod[0] ;
            A3CliCod = P01BG2_A3CliCod[0] ;
            AV10empresaliquidaReligion = (short)((byte)((true)?1:0)) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      if ( ! (GXutil.strcmp("", AV11EmpOrigen)==0) )
      {
         /* Using cursor P01BG3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV15EmpCod), AV11EmpOrigen});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1238EmpOrigen = P01BG3_A1238EmpOrigen[0] ;
            A1EmpCod = P01BG3_A1EmpCod[0] ;
            A3CliCod = P01BG3_A3CliCod[0] ;
            AV12empresaliquidaOrigen = true ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      if ( ! (GXutil.strcmp("", AV13EmpConvenio)==0) )
      {
         /* Using cursor P01BG4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV15EmpCod), AV13EmpConvenio});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A1239EmpConvenio = P01BG4_A1239EmpConvenio[0] ;
            A1EmpCod = P01BG4_A1EmpCod[0] ;
            A3CliCod = P01BG4_A3CliCod[0] ;
            AV14empresaliquidaConvenio = true ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getempreligorigconvenio.this.AV10empresaliquidaReligion;
      this.aP6[0] = getempreligorigconvenio.this.AV12empresaliquidaOrigen;
      this.aP7[0] = getempreligorigconvenio.this.AV14empresaliquidaConvenio;
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
      P01BG2_A1237EmpReligion = new String[] {""} ;
      P01BG2_A1EmpCod = new short[1] ;
      P01BG2_A3CliCod = new int[1] ;
      A1237EmpReligion = "" ;
      P01BG3_A1238EmpOrigen = new String[] {""} ;
      P01BG3_A1EmpCod = new short[1] ;
      P01BG3_A3CliCod = new int[1] ;
      A1238EmpOrigen = "" ;
      P01BG4_A1239EmpConvenio = new String[] {""} ;
      P01BG4_A1EmpCod = new short[1] ;
      P01BG4_A3CliCod = new int[1] ;
      A1239EmpConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempreligorigconvenio__default(),
         new Object[] {
             new Object[] {
            P01BG2_A1237EmpReligion, P01BG2_A1EmpCod, P01BG2_A3CliCod
            }
            , new Object[] {
            P01BG3_A1238EmpOrigen, P01BG3_A1EmpCod, P01BG3_A3CliCod
            }
            , new Object[] {
            P01BG4_A1239EmpConvenio, P01BG4_A1EmpCod, P01BG4_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV10empresaliquidaReligion ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8EmpReligion ;
   private String AV11EmpOrigen ;
   private String AV13EmpConvenio ;
   private String scmdbuf ;
   private String A1237EmpReligion ;
   private String A1238EmpOrigen ;
   private String A1239EmpConvenio ;
   private boolean AV12empresaliquidaOrigen ;
   private boolean AV14empresaliquidaConvenio ;
   private boolean[] aP7 ;
   private short[] aP5 ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BG2_A1237EmpReligion ;
   private short[] P01BG2_A1EmpCod ;
   private int[] P01BG2_A3CliCod ;
   private String[] P01BG3_A1238EmpOrigen ;
   private short[] P01BG3_A1EmpCod ;
   private int[] P01BG3_A3CliCod ;
   private String[] P01BG4_A1239EmpConvenio ;
   private short[] P01BG4_A1EmpCod ;
   private int[] P01BG4_A3CliCod ;
}

final  class getempreligorigconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BG2", "SELECT EmpReligion, EmpCod, CliCod FROM Empresanolaborables_religion WHERE CliCod = ? and EmpCod = ? and EmpReligion = ( ?) ORDER BY CliCod, EmpCod, EmpReligion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01BG3", "SELECT EmpOrigen, EmpCod, CliCod FROM Empresanolaborables_origen WHERE CliCod = ? and EmpCod = ? and EmpOrigen = ( ?) ORDER BY CliCod, EmpCod, EmpOrigen ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01BG4", "SELECT EmpConvenio, EmpCod, CliCod FROM Empresanolaborables_convenio WHERE CliCod = ? and EmpCod = ? and EmpConvenio = ( ?) ORDER BY CliCod, EmpCod, EmpConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

