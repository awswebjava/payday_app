package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvenioparafondocese extends GXProcedure
{
   public getconvenioparafondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvenioparafondocese.class ), "" );
   }

   public getconvenioparafondocese( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getconvenioparafondocese.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getconvenioparafondocese.this.AV10CliCod = aP0;
      getconvenioparafondocese.this.AV9EmpCod = aP1;
      getconvenioparafondocese.this.aP2 = aP2;
      getconvenioparafondocese.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8SinCod ;
      new web.getsindicatodefault(remoteHandle, context).execute( AV10CliCod, AV9EmpCod, GXv_char1) ;
      getconvenioparafondocese.this.AV8SinCod = GXv_char1[0] ;
      if ( (GXutil.strcmp("", AV8SinCod)==0) )
      {
         AV11error = httpContext.getMessage( "No se pudo recuperar sindicato representativo de la actividad económica", "") ;
      }
      else
      {
         GXv_int2[0] = AV12PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
         getconvenioparafondocese.this.AV12PaiCod = GXv_int2[0] ;
         /* Using cursor P02252 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV12PaiCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1564CliPaiConve = P02252_A1564CliPaiConve[0] ;
            A3CliCod = P02252_A3CliCod[0] ;
            A1565CliConvenio = P02252_A1565CliConvenio[0] ;
            AV13CliConvenio = A1565CliConvenio ;
            /* Execute user subroutine: 'MANEJA FONDO' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV14ConveFondoCese )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( ! AV14ConveFondoCese )
         {
            AV13CliConvenio = "" ;
            AV11error = httpContext.getMessage( "No se pudo recuperar convenio para configuración de fondo de cese laboral", "") ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'MANEJA FONDO' Routine */
      returnInSub = false ;
      /* Using cursor P02253 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV12PaiCod), AV13CliConvenio});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P02253_A3CliCod[0] ;
         A1564CliPaiConve = P02253_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02253_A1565CliConvenio[0] ;
         A1401ConveFondoCese = P02253_A1401ConveFondoCese[0] ;
         A1575CliConveVig = P02253_A1575CliConveVig[0] ;
         AV14ConveFondoCese = A1401ConveFondoCese ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconvenioparafondocese.this.AV13CliConvenio;
      this.aP3[0] = getconvenioparafondocese.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13CliConvenio = "" ;
      AV11error = "" ;
      AV8SinCod = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P02252_A1564CliPaiConve = new short[1] ;
      P02252_A3CliCod = new int[1] ;
      P02252_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      P02253_A3CliCod = new int[1] ;
      P02253_A1564CliPaiConve = new short[1] ;
      P02253_A1565CliConvenio = new String[] {""} ;
      P02253_A1401ConveFondoCese = new boolean[] {false} ;
      P02253_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1575CliConveVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvenioparafondocese__default(),
         new Object[] {
             new Object[] {
            P02252_A1564CliPaiConve, P02252_A3CliCod, P02252_A1565CliConvenio
            }
            , new Object[] {
            P02253_A3CliCod, P02253_A1564CliPaiConve, P02253_A1565CliConvenio, P02253_A1401ConveFondoCese, P02253_A1575CliConveVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12PaiCod ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV13CliConvenio ;
   private String AV8SinCod ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date A1575CliConveVig ;
   private boolean returnInSub ;
   private boolean AV14ConveFondoCese ;
   private boolean A1401ConveFondoCese ;
   private String AV11error ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02252_A1564CliPaiConve ;
   private int[] P02252_A3CliCod ;
   private String[] P02252_A1565CliConvenio ;
   private int[] P02253_A3CliCod ;
   private short[] P02253_A1564CliPaiConve ;
   private String[] P02253_A1565CliConvenio ;
   private boolean[] P02253_A1401ConveFondoCese ;
   private java.util.Date[] P02253_A1575CliConveVig ;
}

final  class getconvenioparafondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02252", "SELECT CliPaiConve, CliCod, CliConvenio FROM ClienteConvenios WHERE CliCod = ? and CliPaiConve = ? ORDER BY CliCod, CliPaiConve ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02253", "SELECT CliCod, CliPaiConve, CliConvenio, ConveFondoCese, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

