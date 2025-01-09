package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabarferiadosdesdejson extends GXProcedure
{
   public grabarferiadosdesdejson( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabarferiadosdesdejson.class ), "" );
   }

   public grabarferiadosdesdejson( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      grabarferiadosdesdejson.this.AV10PaiCod = aP0;
      grabarferiadosdesdejson.this.AV8anio = aP1;
      grabarferiadosdesdejson.this.AV11json = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9feriados.fromJSonString(AV11json, null);
      AV12i = (short)(1) ;
      while ( AV12i <= AV9feriados.size() )
      {
         if ( ! (GXutil.strcmp("", ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Religion())==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV10PaiCod, 4, 0))+httpContext.getMessage( " relig ", "")+GXutil.trim( ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Religion())) ;
            /*
               INSERT RECORD ON TABLE PaisReligion

            */
            A46PaiCod = AV10PaiCod ;
            A1253PaiReligion = GXutil.trim( ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Religion()) ;
            /* Using cursor P01YJ2 */
            pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1253PaiReligion});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisReligion");
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
         if ( ! (GXutil.strcmp("", ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Origen())==0) )
         {
            /*
               INSERT RECORD ON TABLE PaisOrigen

            */
            A46PaiCod = AV10PaiCod ;
            A1282PaiOrigen = ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Origen() ;
            /* Using cursor P01YJ3 */
            pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1282PaiOrigen});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisOrigen");
            if ( (pr_default.getStatus(1) == 1) )
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
         new web.newferiado(remoteHandle, context).execute( AV10PaiCod, GXutil.trim( ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Id()), (byte)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Dia())), (byte)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Mes())), ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Motivo(), ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Religion(), ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Origen(), ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Tipo(), ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Convenio()) ;
         new web.newferiadoagenda(remoteHandle, context).execute( AV10PaiCod, ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Id(), AV8anio, (byte)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Mes())), (short)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Dia()))) ;
         if ( GXutil.strcmp(GXutil.trim( ((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Id()), httpContext.getMessage( "viernes-santo", "")) == 0 )
         {
            AV18viernesSantoFecha = localUtil.ymdtod( AV8anio, (int)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Mes())), (int)(DecimalUtil.decToDouble(((web.Sdtferiados_feriadosItem)AV9feriados.elementAt(-1+AV12i)).getgxTv_Sdtferiados_feriadosItem_Dia()))) ;
         }
         AV12i = (short)(AV12i+1) ;
      }
      /* Using cursor P01YJ4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV10PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1223FerId = P01YJ4_A1223FerId[0] ;
         A46PaiCod = P01YJ4_A46PaiCod[0] ;
         if ( GXutil.strcmp(A1223FerId, httpContext.getMessage( "jueves-santo", "")) == 0 )
         {
            AV16fixJuevesSanto = true ;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV16fixJuevesSanto )
      {
         AV23GXLvl37 = (byte)(0) ;
         /* Using cursor P01YJ5 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV10PaiCod), Short.valueOf(AV8anio)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1226FerAnio = P01YJ5_A1226FerAnio[0] ;
            A1223FerId = P01YJ5_A1223FerId[0] ;
            A46PaiCod = P01YJ5_A46PaiCod[0] ;
            A1227FerFecha = P01YJ5_A1227FerFecha[0] ;
            if ( GXutil.strcmp(A1223FerId, httpContext.getMessage( "jueves-santo", "")) == 0 )
            {
               AV23GXLvl37 = (byte)(1) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( AV23GXLvl37 == 0 )
         {
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18viernesSantoFecha)) )
            {
               AV17juevesSantoFecha = GXutil.dadd( AV18viernesSantoFecha, (-1)) ;
               AV14mesJuevesSanto = (short)(GXutil.month( AV17juevesSantoFecha)) ;
               AV13diaJuevesSanto = (short)(GXutil.day( AV17juevesSantoFecha)) ;
               new web.newferiadoagenda(remoteHandle, context).execute( AV10PaiCod, httpContext.getMessage( "jueves-santo", ""), AV8anio, (byte)(AV14mesJuevesSanto), AV13diaJuevesSanto) ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabarferiadosdesdejson");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9feriados = new GXBaseCollection<web.Sdtferiados_feriadosItem>(web.Sdtferiados_feriadosItem.class, "feriadosItem", "PayDay", remoteHandle);
      AV21Pgmname = "" ;
      A1253PaiReligion = "" ;
      Gx_emsg = "" ;
      A1282PaiOrigen = "" ;
      AV18viernesSantoFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01YJ4_A1223FerId = new String[] {""} ;
      P01YJ4_A46PaiCod = new short[1] ;
      A1223FerId = "" ;
      P01YJ5_A1226FerAnio = new short[1] ;
      P01YJ5_A1223FerId = new String[] {""} ;
      P01YJ5_A46PaiCod = new short[1] ;
      P01YJ5_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A1227FerFecha = GXutil.nullDate() ;
      AV17juevesSantoFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabarferiadosdesdejson__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01YJ4_A1223FerId, P01YJ4_A46PaiCod
            }
            , new Object[] {
            P01YJ5_A1226FerAnio, P01YJ5_A1223FerId, P01YJ5_A46PaiCod, P01YJ5_A1227FerFecha
            }
         }
      );
      AV21Pgmname = "grabarFeriadosDesdeJson" ;
      /* GeneXus formulas. */
      AV21Pgmname = "grabarFeriadosDesdeJson" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23GXLvl37 ;
   private short AV10PaiCod ;
   private short AV8anio ;
   private short AV12i ;
   private short A46PaiCod ;
   private short Gx_err ;
   private short A1226FerAnio ;
   private short AV14mesJuevesSanto ;
   private short AV13diaJuevesSanto ;
   private int GX_INS150 ;
   private int GX_INS152 ;
   private String AV21Pgmname ;
   private String A1253PaiReligion ;
   private String Gx_emsg ;
   private String A1282PaiOrigen ;
   private String scmdbuf ;
   private String A1223FerId ;
   private java.util.Date AV18viernesSantoFecha ;
   private java.util.Date A1227FerFecha ;
   private java.util.Date AV17juevesSantoFecha ;
   private boolean AV16fixJuevesSanto ;
   private String AV11json ;
   private IDataStoreProvider pr_default ;
   private String[] P01YJ4_A1223FerId ;
   private short[] P01YJ4_A46PaiCod ;
   private short[] P01YJ5_A1226FerAnio ;
   private String[] P01YJ5_A1223FerId ;
   private short[] P01YJ5_A46PaiCod ;
   private java.util.Date[] P01YJ5_A1227FerFecha ;
   private GXBaseCollection<web.Sdtferiados_feriadosItem> AV9feriados ;
}

final  class grabarferiadosdesdejson__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01YJ2", "SAVEPOINT gxupdate;INSERT INTO PaisReligion(PaiCod, PaiReligion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01YJ3", "SAVEPOINT gxupdate;INSERT INTO PaisOrigen(PaiCod, PaiOrigen) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01YJ4", "SELECT FerId, PaiCod FROM feriado WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01YJ5", "SELECT FerAnio, FerId, PaiCod, FerFecha FROM feriado_agenda WHERE (PaiCod = ?) AND (FerAnio = ?) ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

