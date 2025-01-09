package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getareagendeactlabclaspordesc extends GXProcedure
{
   public getareagendeactlabclaspordesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getareagendeactlabclaspordesc.class ), "" );
   }

   public getareagendeactlabclaspordesc( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      getareagendeactlabclaspordesc.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getareagendeactlabclaspordesc.this.AV9PaiCod = aP0;
      getareagendeactlabclaspordesc.this.AV8ActLabDesSinAc = aP1;
      getareagendeactlabclaspordesc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025B2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), AV8ActLabDesSinAc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2220ActLabDesSinAc = P025B2_A2220ActLabDesSinAc[0] ;
         A46PaiCod = P025B2_A46PaiCod[0] ;
         A2219ActLabAreaGen = P025B2_A2219ActLabAreaGen[0] ;
         A2217ActLabNro = P025B2_A2217ActLabNro[0] ;
         AV10ActLabAreaGen = A2219ActLabAreaGen ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getareagendeactlabclaspordesc.this.AV10ActLabAreaGen;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ActLabAreaGen = "" ;
      scmdbuf = "" ;
      P025B2_A2220ActLabDesSinAc = new String[] {""} ;
      P025B2_A46PaiCod = new short[1] ;
      P025B2_A2219ActLabAreaGen = new String[] {""} ;
      P025B2_A2217ActLabNro = new int[1] ;
      A2220ActLabDesSinAc = "" ;
      A2219ActLabAreaGen = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getareagendeactlabclaspordesc__default(),
         new Object[] {
             new Object[] {
            P025B2_A2220ActLabDesSinAc, P025B2_A46PaiCod, P025B2_A2219ActLabAreaGen, P025B2_A2217ActLabNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int A2217ActLabNro ;
   private String scmdbuf ;
   private String AV8ActLabDesSinAc ;
   private String AV10ActLabAreaGen ;
   private String A2220ActLabDesSinAc ;
   private String A2219ActLabAreaGen ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P025B2_A2220ActLabDesSinAc ;
   private short[] P025B2_A46PaiCod ;
   private String[] P025B2_A2219ActLabAreaGen ;
   private int[] P025B2_A2217ActLabNro ;
}

final  class getareagendeactlabclaspordesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025B2", "SELECT ActLabDesSinAc, PaiCod, ActLabAreaGen, ActLabNro FROM ActividadLaboralClasificada WHERE (PaiCod = ?) AND (ActLabDesSinAc = ( ?)) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

