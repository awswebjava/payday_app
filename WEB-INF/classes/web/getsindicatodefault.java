package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatodefault extends GXProcedure
{
   public getsindicatodefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatodefault.class ), "" );
   }

   public getsindicatodefault( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getsindicatodefault.this.aP2 = new String[] {""};
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
      getsindicatodefault.this.AV12CliCod = aP0;
      getsindicatodefault.this.AV11EmpCod = aP1;
      getsindicatodefault.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8ActComCodigo ;
      new web.empresagetactcomercial(remoteHandle, context).execute( AV12CliCod, AV11EmpCod, GXv_char1) ;
      getsindicatodefault.this.AV8ActComCodigo = GXv_char1[0] ;
      GXv_int2[0] = AV13PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
      getsindicatodefault.this.AV13PaiCod = GXv_int2[0] ;
      /* Using cursor P00YB2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13PaiCod), AV8ActComCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A906SinDefault = P00YB2_A906SinDefault[0] ;
         A903ActComCodigo = P00YB2_A903ActComCodigo[0] ;
         A46PaiCod = P00YB2_A46PaiCod[0] ;
         A14SinCod = P00YB2_A14SinCod[0] ;
         AV9SinCod = A14SinCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( (GXutil.strcmp("", AV9SinCod)==0) )
      {
         /* Using cursor P00YB3 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV13PaiCod), AV8ActComCodigo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A903ActComCodigo = P00YB3_A903ActComCodigo[0] ;
            A46PaiCod = P00YB3_A46PaiCod[0] ;
            A14SinCod = P00YB3_A14SinCod[0] ;
            AV9SinCod = A14SinCod ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      if ( (GXutil.strcmp("", AV9SinCod)==0) )
      {
         /* Using cursor P00YB4 */
         pr_default.execute(2, new Object[] {Short.valueOf(AV13PaiCod)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A46PaiCod = P00YB4_A46PaiCod[0] ;
            A14SinCod = P00YB4_A14SinCod[0] ;
            AV9SinCod = A14SinCod ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatodefault.this.AV9SinCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SinCod = "" ;
      AV8ActComCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00YB2_A906SinDefault = new boolean[] {false} ;
      P00YB2_A903ActComCodigo = new String[] {""} ;
      P00YB2_A46PaiCod = new short[1] ;
      P00YB2_A14SinCod = new String[] {""} ;
      A903ActComCodigo = "" ;
      A14SinCod = "" ;
      P00YB3_A903ActComCodigo = new String[] {""} ;
      P00YB3_A46PaiCod = new short[1] ;
      P00YB3_A14SinCod = new String[] {""} ;
      P00YB4_A46PaiCod = new short[1] ;
      P00YB4_A14SinCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatodefault__default(),
         new Object[] {
             new Object[] {
            P00YB2_A906SinDefault, P00YB2_A903ActComCodigo, P00YB2_A46PaiCod, P00YB2_A14SinCod
            }
            , new Object[] {
            P00YB3_A903ActComCodigo, P00YB3_A46PaiCod, P00YB3_A14SinCod
            }
            , new Object[] {
            P00YB4_A46PaiCod, P00YB4_A14SinCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV13PaiCod ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV9SinCod ;
   private String AV8ActComCodigo ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A903ActComCodigo ;
   private String A14SinCod ;
   private boolean A906SinDefault ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P00YB2_A906SinDefault ;
   private String[] P00YB2_A903ActComCodigo ;
   private short[] P00YB2_A46PaiCod ;
   private String[] P00YB2_A14SinCod ;
   private String[] P00YB3_A903ActComCodigo ;
   private short[] P00YB3_A46PaiCod ;
   private String[] P00YB3_A14SinCod ;
   private short[] P00YB4_A46PaiCod ;
   private String[] P00YB4_A14SinCod ;
}

final  class getsindicatodefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YB2", "SELECT SinDefault, ActComCodigo, PaiCod, SinCod FROM Sindicato WHERE (PaiCod = ?) AND (ActComCodigo = ( ?)) AND (SinDefault = TRUE) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00YB3", "SELECT ActComCodigo, PaiCod, SinCod FROM Sindicato WHERE (PaiCod = ?) AND (ActComCodigo = ( ?)) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00YB4", "SELECT PaiCod, SinCod FROM Sindicato WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

