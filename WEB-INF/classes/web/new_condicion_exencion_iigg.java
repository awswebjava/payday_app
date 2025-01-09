package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_condicion_exencion_iigg extends GXProcedure
{
   public new_condicion_exencion_iigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_condicion_exencion_iigg.class ), "" );
   }

   public new_condicion_exencion_iigg( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        boolean aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             boolean aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 )
   {
      new_condicion_exencion_iigg.this.AV14CliCod = aP0;
      new_condicion_exencion_iigg.this.AV13CondExenIIGG = aP1;
      new_condicion_exencion_iigg.this.AV12CondExenIIGGCon = aP2;
      new_condicion_exencion_iigg.this.AV11CondExenIIGGAcu = aP3;
      new_condicion_exencion_iigg.this.AV10CondExenIIGGProm = aP4;
      new_condicion_exencion_iigg.this.AV9OpeCliId = aP5;
      new_condicion_exencion_iigg.this.AV8CondexenIIGGNom = aP6;
      new_condicion_exencion_iigg.this.AV17CondExenIIGGVFi = aP7;
      new_condicion_exencion_iigg.this.AV16CondExenIIGGOpe = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV15existe ;
      new web.existeconcepto(remoteHandle, context).execute( AV14CliCod, AV12CondExenIIGGCon, GXv_boolean1) ;
      new_condicion_exencion_iigg.this.AV15existe = GXv_boolean1[0] ;
      if ( AV15existe )
      {
         /*
            INSERT RECORD ON TABLE condicion_exencion_iigg

         */
         A3CliCod = AV14CliCod ;
         A1105CondExenIIGG = AV13CondExenIIGG ;
         A1104CondExenIIGGCon = AV12CondExenIIGGCon ;
         A1106CondExenIIGGAcu = AV11CondExenIIGGAcu ;
         A1107CondExenIIGGProm = AV10CondExenIIGGProm ;
         if ( ! (GXutil.strcmp("", AV9OpeCliId)==0) )
         {
            A1123CondExenIIGGVar = AV9OpeCliId ;
            n1123CondExenIIGGVar = false ;
         }
         else
         {
            A1123CondExenIIGGVar = "" ;
            n1123CondExenIIGGVar = false ;
            n1123CondExenIIGGVar = true ;
         }
         A2237CondExenIIGGVFi = AV17CondExenIIGGVFi ;
         A2238CondExenIIGGOpe = AV16CondExenIIGGOpe ;
         A1108CondexenIIGGNom = AV8CondexenIIGGNom ;
         A2001CondExenRelSec = 0 ;
         A2002CondRelSecCli = 0 ;
         A2021CondExenRelRef = "" ;
         A2027CondExenOld = "" ;
         /* Using cursor P016Y2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG, A1104CondExenIIGGCon, Boolean.valueOf(A1106CondExenIIGGAcu), Boolean.valueOf(A1107CondExenIIGGProm), A1108CondexenIIGGNom, Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar, Integer.valueOf(A2001CondExenRelSec), Integer.valueOf(A2002CondRelSecCli), A2021CondExenRelRef, A2027CondExenOld, A2237CondExenIIGGVFi, A2238CondExenIIGGOpe});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("condicion_exencion_iigg");
         if ( (pr_default.getStatus(0) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "new_condicion_exencion_iigg");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean1 = new boolean[1] ;
      A1105CondExenIIGG = "" ;
      A1104CondExenIIGGCon = "" ;
      A1123CondExenIIGGVar = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A2238CondExenIIGGOpe = "" ;
      A1108CondexenIIGGNom = "" ;
      A2021CondExenRelRef = "" ;
      A2027CondExenOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_condicion_exencion_iigg__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14CliCod ;
   private int GX_INS124 ;
   private int A3CliCod ;
   private int A2001CondExenRelSec ;
   private int A2002CondRelSecCli ;
   private java.math.BigDecimal AV17CondExenIIGGVFi ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String AV13CondExenIIGG ;
   private String AV12CondExenIIGGCon ;
   private String AV9OpeCliId ;
   private String AV16CondExenIIGGOpe ;
   private String A1105CondExenIIGG ;
   private String A1104CondExenIIGGCon ;
   private String A1123CondExenIIGGVar ;
   private String A2238CondExenIIGGOpe ;
   private String Gx_emsg ;
   private boolean AV11CondExenIIGGAcu ;
   private boolean AV10CondExenIIGGProm ;
   private boolean AV15existe ;
   private boolean GXv_boolean1[] ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean n1123CondExenIIGGVar ;
   private String A2027CondExenOld ;
   private String AV8CondexenIIGGNom ;
   private String A1108CondexenIIGGNom ;
   private String A2021CondExenRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class new_condicion_exencion_iigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P016Y2", "SAVEPOINT gxupdate;INSERT INTO condicion_exencion_iigg(CliCod, CondExenIIGG, CondExenIIGGCon, CondExenIIGGAcu, CondExenIIGGProm, CondexenIIGGNom, CondExenIIGGVar, CondExenRelSec, CondRelSecCli, CondExenRelRef, CondExenOld, CondExenIIGGVFi, CondExenIIGGOpe) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setString(3, (String)parms[2], 10);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(6, (String)parms[5], 400, false);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 40);
               }
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setString(13, (String)parms[13], 20);
               return;
      }
   }

}

