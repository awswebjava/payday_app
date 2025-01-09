package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondiiggbonos extends GXProcedure
{
   public getcondiiggbonos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondiiggbonos.class ), "" );
   }

   public getcondiiggbonos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getcondiiggbonos.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getcondiiggbonos.this.AV9CliCod = aP0;
      getcondiiggbonos.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV10CondExenIIGGCon ;
      GXt_char2 = AV10CondExenIIGGCon ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getcondiiggbonos.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      getcondiiggbonos.this.GXt_char1 = GXv_char4[0] ;
      AV10CondExenIIGGCon = GXt_char1 ;
      AV11CondExenIIGGAcu = true ;
      AV12CondExenIIGGProm = true ;
      /* Using cursor P017F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10CondExenIIGGCon, Boolean.valueOf(AV11CondExenIIGGAcu), Boolean.valueOf(AV12CondExenIIGGProm)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1107CondExenIIGGProm = P017F2_A1107CondExenIIGGProm[0] ;
         A1106CondExenIIGGAcu = P017F2_A1106CondExenIIGGAcu[0] ;
         A1104CondExenIIGGCon = P017F2_A1104CondExenIIGGCon[0] ;
         A3CliCod = P017F2_A3CliCod[0] ;
         A1105CondExenIIGG = P017F2_A1105CondExenIIGG[0] ;
         AV8CondExenIIGG = A1105CondExenIIGG ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcondiiggbonos.this.AV8CondExenIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CondExenIIGG = "" ;
      AV10CondExenIIGGCon = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P017F2_A1107CondExenIIGGProm = new boolean[] {false} ;
      P017F2_A1106CondExenIIGGAcu = new boolean[] {false} ;
      P017F2_A1104CondExenIIGGCon = new String[] {""} ;
      P017F2_A3CliCod = new int[1] ;
      P017F2_A1105CondExenIIGG = new String[] {""} ;
      A1104CondExenIIGGCon = "" ;
      A1105CondExenIIGG = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondiiggbonos__default(),
         new Object[] {
             new Object[] {
            P017F2_A1107CondExenIIGGProm, P017F2_A1106CondExenIIGGAcu, P017F2_A1104CondExenIIGGCon, P017F2_A3CliCod, P017F2_A1105CondExenIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8CondExenIIGG ;
   private String AV10CondExenIIGGCon ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A1104CondExenIIGGCon ;
   private String A1105CondExenIIGG ;
   private boolean AV11CondExenIIGGAcu ;
   private boolean AV12CondExenIIGGProm ;
   private boolean A1107CondExenIIGGProm ;
   private boolean A1106CondExenIIGGAcu ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P017F2_A1107CondExenIIGGProm ;
   private boolean[] P017F2_A1106CondExenIIGGAcu ;
   private String[] P017F2_A1104CondExenIIGGCon ;
   private int[] P017F2_A3CliCod ;
   private String[] P017F2_A1105CondExenIIGG ;
}

final  class getcondiiggbonos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017F2", "SELECT CondExenIIGGProm, CondExenIIGGAcu, CondExenIIGGCon, CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE (CliCod = ? and CondExenIIGGCon = ( ?)) AND (CondExenIIGGAcu = ?) AND (CondExenIIGGProm = ?) ORDER BY CliCod, CondExenIIGGCon  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               return;
      }
   }

}

