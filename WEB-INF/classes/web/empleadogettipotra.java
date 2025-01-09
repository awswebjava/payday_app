package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadogettipotra extends GXProcedure
{
   public empleadogettipotra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadogettipotra.class ), "" );
   }

   public empleadogettipotra( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<String> aP3 ,
                             boolean[] aP4 ,
                             String[] aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 )
   {
      empleadogettipotra.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<String> aP3 ,
                        boolean[] aP4 ,
                        String[] aP5 ,
                        boolean[] aP6 ,
                        String[] aP7 ,
                        boolean[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<String> aP3 ,
                             boolean[] aP4 ,
                             String[] aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 ,
                             String[] aP9 )
   {
      empleadogettipotra.this.AV11CliCod = aP0;
      empleadogettipotra.this.AV12empcod = aP1;
      empleadogettipotra.this.AV8LegNumero = aP2;
      empleadogettipotra.this.AV13LegTipoTra = aP3;
      empleadogettipotra.this.aP4 = aP4;
      empleadogettipotra.this.aP5 = aP5;
      empleadogettipotra.this.aP6 = aP6;
      empleadogettipotra.this.aP7 = aP7;
      empleadogettipotra.this.aP8 = aP8;
      empleadogettipotra.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV8LegNumero) )
      {
         AV14diurnoEs = true ;
         AV15diurnoLegTipoTra = "diurno" ;
      }
      else
      {
         if ( (0==AV8LegNumero) && ( AV13LegTipoTra.size() > 0 ) )
         {
            AV20i = (short)(1) ;
            while ( AV20i <= AV13LegTipoTra.size() )
            {
               if ( GXutil.strcmp((String)AV13LegTipoTra.elementAt(-1+AV20i), "diurno") == 0 )
               {
                  AV14diurnoEs = true ;
                  AV15diurnoLegTipoTra = (String)AV13LegTipoTra.elementAt(-1+AV20i) ;
               }
               if ( GXutil.strcmp((String)AV13LegTipoTra.elementAt(-1+AV20i), "nocturno") == 0 )
               {
                  AV17nocturnoEs = true ;
                  AV16nocturnoLegTipoTra = (String)AV13LegTipoTra.elementAt(-1+AV20i) ;
               }
               if ( GXutil.strcmp((String)AV13LegTipoTra.elementAt(-1+AV20i), "insalubre") == 0 )
               {
                  AV19insalubreEs = true ;
                  AV18insalubreLegTipoTra = (String)AV13LegTipoTra.elementAt(-1+AV20i) ;
               }
               AV20i = (short)(AV20i+1) ;
            }
         }
         else
         {
            /* Using cursor P01CF2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A6LegNumero = P01CF2_A6LegNumero[0] ;
               A1EmpCod = P01CF2_A1EmpCod[0] ;
               A3CliCod = P01CF2_A3CliCod[0] ;
               A1319LegTipoTra = P01CF2_A1319LegTipoTra[0] ;
               if ( GXutil.strcmp(A1319LegTipoTra, "diurno") == 0 )
               {
                  AV14diurnoEs = true ;
                  AV15diurnoLegTipoTra = A1319LegTipoTra ;
               }
               if ( GXutil.strcmp(A1319LegTipoTra, "nocturno") == 0 )
               {
                  AV17nocturnoEs = true ;
                  AV16nocturnoLegTipoTra = A1319LegTipoTra ;
               }
               if ( GXutil.strcmp(A1319LegTipoTra, "insalubre") == 0 )
               {
                  AV19insalubreEs = true ;
                  AV18insalubreLegTipoTra = A1319LegTipoTra ;
               }
               pr_default.readNext(0);
            }
            pr_default.close(0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadogettipotra.this.AV14diurnoEs;
      this.aP5[0] = empleadogettipotra.this.AV15diurnoLegTipoTra;
      this.aP6[0] = empleadogettipotra.this.AV17nocturnoEs;
      this.aP7[0] = empleadogettipotra.this.AV16nocturnoLegTipoTra;
      this.aP8[0] = empleadogettipotra.this.AV19insalubreEs;
      this.aP9[0] = empleadogettipotra.this.AV18insalubreLegTipoTra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15diurnoLegTipoTra = "" ;
      AV16nocturnoLegTipoTra = "" ;
      AV18insalubreLegTipoTra = "" ;
      scmdbuf = "" ;
      P01CF2_A6LegNumero = new int[1] ;
      P01CF2_A1EmpCod = new short[1] ;
      P01CF2_A3CliCod = new int[1] ;
      P01CF2_A1319LegTipoTra = new String[] {""} ;
      A1319LegTipoTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadogettipotra__default(),
         new Object[] {
             new Object[] {
            P01CF2_A6LegNumero, P01CF2_A1EmpCod, P01CF2_A3CliCod, P01CF2_A1319LegTipoTra
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short AV20i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV15diurnoLegTipoTra ;
   private String AV16nocturnoLegTipoTra ;
   private String AV18insalubreLegTipoTra ;
   private String scmdbuf ;
   private String A1319LegTipoTra ;
   private boolean AV14diurnoEs ;
   private boolean AV17nocturnoEs ;
   private boolean AV19insalubreEs ;
   private String[] aP9 ;
   private boolean[] aP4 ;
   private String[] aP5 ;
   private boolean[] aP6 ;
   private String[] aP7 ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CF2_A6LegNumero ;
   private short[] P01CF2_A1EmpCod ;
   private int[] P01CF2_A3CliCod ;
   private String[] P01CF2_A1319LegTipoTra ;
   private GXSimpleCollection<String> AV13LegTipoTra ;
}

final  class empleadogettipotra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CF2", "SELECT LegNumero, EmpCod, CliCod, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

