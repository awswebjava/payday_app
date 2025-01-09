package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem extends GxUserType
{
   public Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem( )
   {
      this(  new ModelContext(Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem.class));
   }

   public Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem( ModelContext context )
   {
      super( context, "Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem");
   }

   public Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem");
   }

   public Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem( StructSdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "iconoUpdate") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegId") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCUIL") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegApellido") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNombre") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModTra") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTipoTarifa") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegClase") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac = GXutil.nullDate() ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N = (byte)(0) ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecIngreso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso = GXutil.nullDate() ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N = (byte)(0) ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSexo") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegZona") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDomici") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCodPos") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTelefono") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEmail") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEstadoCivil") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDiscapacidad") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegArea") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBasico") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegConvenio") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCategoria_var") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCategoria") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegLugarDePago") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanco") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegObraSocial") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanSuc") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanTipCuen") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCuentaBanc") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFormaPago") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCBU") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModalidad") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegHorSem") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActividad") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSituacionRevista") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCondicion") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSiniestrado") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSCVO") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPlanMedico") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTieneConyuge") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrCantidadHijos") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegObs") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPeriodo") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo = GXutil.nullDate() ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N = (byte)(0) ;
                  gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrSueldos") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPuesto") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActLabClas") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPueAfip") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSindicato") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "VerSVG") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ModificarSVG") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EliminarSVG") )
            {
               gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "importacion_legajoWWSDT.importacion_legajoWWSDTItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("iconoUpdate", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNumero", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegId", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCUIL", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegApellido", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNombre", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegModTra", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegTipoTarifa", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegClase", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac)) && ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N == 1 ) )
      {
         oWriter.writeElement("MigrLegFecNac", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecNac", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso)) && ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N == 1 ) )
      {
         oWriter.writeElement("MigrLegFecIngreso", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecIngreso", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("MigrLegSexo", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegZona", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegDomici", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCodPos", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegTelefono", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegEmail", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegEstadoCivil", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegDiscapacidad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegArea", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBasico", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegConvenio", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCategoria_var", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCategoria", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegLugarDePago", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanco", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegObraSocial", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanSuc", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanTipCuen", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCuentaBanc", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFormaPago", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCBU", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegModalidad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegHorSem", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegActividad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSituacionRevista", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCondicion", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSiniestrado", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSCVO", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegPlanMedico", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrTieneConyuge", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrCantidadHijos", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegObs", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo)) && ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N == 1 ) )
      {
         oWriter.writeElement("MigrPeriodo", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrPeriodo", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("MigrSueldos", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrPuesto", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegActLabClas", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegPueAfip", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSindicato", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("VerSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ModificarSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EliminarSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("iconoUpdate", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate, false, false);
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod, false, false);
      AddObjectProperty("MigrLegNumero", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero, false, false);
      AddObjectProperty("MigrLegId", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid, false, false);
      AddObjectProperty("MigrLegCUIL", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil, false, false);
      AddObjectProperty("MigrLegApellido", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido, false, false);
      AddObjectProperty("MigrLegNombre", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre, false, false);
      AddObjectProperty("MigrLegModTra", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra, false, false);
      AddObjectProperty("MigrLegTipoTarifa", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa, false, false);
      AddObjectProperty("MigrLegClase", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecNac", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecIngreso", sDateCnv, false, false);
      AddObjectProperty("MigrLegSexo", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo, false, false);
      AddObjectProperty("MigrLegZona", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona, false, false);
      AddObjectProperty("MigrLegDomici", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici, false, false);
      AddObjectProperty("MigrLegCodPos", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos, false, false);
      AddObjectProperty("MigrLegTelefono", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono, false, false);
      AddObjectProperty("MigrLegEmail", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail, false, false);
      AddObjectProperty("MigrLegEstadoCivil", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil, false, false);
      AddObjectProperty("MigrLegDiscapacidad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad, false, false);
      AddObjectProperty("MigrLegArea", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea, false, false);
      AddObjectProperty("MigrLegBasico", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico, false, false);
      AddObjectProperty("MigrLegConvenio", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio, false, false);
      AddObjectProperty("MigrLegCategoria_var", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var, false, false);
      AddObjectProperty("MigrLegCategoria", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria, false, false);
      AddObjectProperty("MigrLegLugarDePago", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago, false, false);
      AddObjectProperty("MigrLegBanco", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco, false, false);
      AddObjectProperty("MigrLegObraSocial", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial, false, false);
      AddObjectProperty("MigrLegBanSuc", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc, false, false);
      AddObjectProperty("MigrLegBanTipCuen", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen, false, false);
      AddObjectProperty("MigrLegCuentaBanc", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc, false, false);
      AddObjectProperty("MigrLegFormaPago", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago, false, false);
      AddObjectProperty("MigrLegCBU", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu, false, false);
      AddObjectProperty("MigrLegModalidad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad, false, false);
      AddObjectProperty("MigrLegHorSem", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem, false, false);
      AddObjectProperty("MigrLegActividad", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad, false, false);
      AddObjectProperty("MigrLegSituacionRevista", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista, false, false);
      AddObjectProperty("MigrLegCondicion", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion, false, false);
      AddObjectProperty("MigrLegSiniestrado", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado, false, false);
      AddObjectProperty("MigrLegSCVO", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo, false, false);
      AddObjectProperty("MigrLegPlanMedico", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico, false, false);
      AddObjectProperty("MigrTieneConyuge", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge, false, false);
      AddObjectProperty("MigrCantidadHijos", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos, false, false);
      AddObjectProperty("MigrLegObs", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrPeriodo", sDateCnv, false, false);
      AddObjectProperty("MigrSueldos", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos, false, false);
      AddObjectProperty("MigrPuesto", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto, false, false);
      AddObjectProperty("MigrLegActLabClas", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas, false, false);
      AddObjectProperty("MigrLegPueAfip", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip, false, false);
      AddObjectProperty("MigrLegSindicato", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato, false, false);
      AddObjectProperty("VerSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg, false, false);
      AddObjectProperty("ModificarSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg, false, false);
      AddObjectProperty("EliminarSVG", gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg, false, false);
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate = value ;
   }

   public int getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod( int value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod( short value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod = value ;
   }

   public int getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero( int value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge = value ;
   }

   public short getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos( short value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg = value ;
   }

   public String getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg ;
   }

   public void setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg( String value )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg = "" ;
      gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N ;
   }

   public web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem Clone( )
   {
      return (web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)(clone()) ;
   }

   public void setStruct( web.StructSdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem struct )
   {
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate(struct.getIconoupdate());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(struct.getMigrlegnumero());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid(struct.getMigrlegid());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil(struct.getMigrlegcuil());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido(struct.getMigrlegapellido());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre(struct.getMigrlegnombre());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra(struct.getMigrlegmodtra());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa(struct.getMigrlegtipotarifa());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase(struct.getMigrlegclase());
      if ( struct.gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N == 0 )
      {
         setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac(struct.getMigrlegfecnac());
      }
      if ( struct.gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N == 0 )
      {
         setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso(struct.getMigrlegfecingreso());
      }
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo(struct.getMigrlegsexo());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona(struct.getMigrlegzona());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici(struct.getMigrlegdomici());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos(struct.getMigrlegcodpos());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono(struct.getMigrlegtelefono());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail(struct.getMigrlegemail());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil(struct.getMigrlegestadocivil());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad(struct.getMigrlegdiscapacidad());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea(struct.getMigrlegarea());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico(struct.getMigrlegbasico());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio(struct.getMigrlegconvenio());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var(struct.getMigrlegcategoria_var());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria(struct.getMigrlegcategoria());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago(struct.getMigrleglugardepago());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco(struct.getMigrlegbanco());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(struct.getMigrlegobrasocial());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc(struct.getMigrlegbansuc());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen(struct.getMigrlegbantipcuen());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc(struct.getMigrlegcuentabanc());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago(struct.getMigrlegformapago());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu(struct.getMigrlegcbu());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad(struct.getMigrlegmodalidad());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem(struct.getMigrleghorsem());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad(struct.getMigrlegactividad());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista(struct.getMigrlegsituacionrevista());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion(struct.getMigrlegcondicion());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado(struct.getMigrlegsiniestrado());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo(struct.getMigrlegscvo());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico(struct.getMigrlegplanmedico());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge(struct.getMigrtieneconyuge());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos(struct.getMigrcantidadhijos());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs(struct.getMigrlegobs());
      if ( struct.gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N == 0 )
      {
         setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo(struct.getMigrperiodo());
      }
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos(struct.getMigrsueldos());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto(struct.getMigrpuesto());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas(struct.getMigrlegactlabclas());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip(struct.getMigrlegpueafip());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato(struct.getMigrlegsindicato());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg(struct.getVersvg());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg(struct.getModificarsvg());
      setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg(struct.getEliminarsvg());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem getStruct( )
   {
      web.StructSdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem struct = new web.StructSdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem ();
      struct.setIconoupdate(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate());
      struct.setClicod(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod());
      struct.setMigrlegnumero(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero());
      struct.setMigrlegid(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid());
      struct.setMigrlegcuil(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil());
      struct.setMigrlegapellido(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido());
      struct.setMigrlegnombre(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre());
      struct.setMigrlegmodtra(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra());
      struct.setMigrlegtipotarifa(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa());
      struct.setMigrlegclase(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase());
      if ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N == 0 )
      {
         struct.setMigrlegfecnac(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac());
      }
      if ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N == 0 )
      {
         struct.setMigrlegfecingreso(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso());
      }
      struct.setMigrlegsexo(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo());
      struct.setMigrlegzona(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona());
      struct.setMigrlegdomici(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici());
      struct.setMigrlegcodpos(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos());
      struct.setMigrlegtelefono(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono());
      struct.setMigrlegemail(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail());
      struct.setMigrlegestadocivil(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil());
      struct.setMigrlegdiscapacidad(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad());
      struct.setMigrlegarea(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea());
      struct.setMigrlegbasico(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico());
      struct.setMigrlegconvenio(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio());
      struct.setMigrlegcategoria_var(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var());
      struct.setMigrlegcategoria(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria());
      struct.setMigrleglugardepago(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago());
      struct.setMigrlegbanco(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco());
      struct.setMigrlegobrasocial(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial());
      struct.setMigrlegbansuc(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc());
      struct.setMigrlegbantipcuen(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen());
      struct.setMigrlegcuentabanc(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc());
      struct.setMigrlegformapago(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago());
      struct.setMigrlegcbu(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu());
      struct.setMigrlegmodalidad(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad());
      struct.setMigrleghorsem(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem());
      struct.setMigrlegactividad(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad());
      struct.setMigrlegsituacionrevista(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista());
      struct.setMigrlegcondicion(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion());
      struct.setMigrlegsiniestrado(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado());
      struct.setMigrlegscvo(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo());
      struct.setMigrlegplanmedico(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico());
      struct.setMigrtieneconyuge(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge());
      struct.setMigrcantidadhijos(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos());
      struct.setMigrlegobs(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs());
      if ( gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N == 0 )
      {
         struct.setMigrperiodo(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo());
      }
      struct.setMigrsueldos(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos());
      struct.setMigrpuesto(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto());
      struct.setMigrlegactlabclas(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas());
      struct.setMigrlegpueafip(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip());
      struct.setMigrlegsindicato(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato());
      struct.setVersvg(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg());
      struct.setModificarsvg(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg());
      struct.setEliminarsvg(getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg());
      return struct ;
   }

   protected byte gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_N ;
   protected byte gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac_N ;
   protected byte gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso_N ;
   protected byte gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo_N ;
   protected short gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod ;
   protected short gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod ;
   protected int gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac ;
   protected java.util.Date gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso ;
   protected java.util.Date gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip ;
   protected String gxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato ;
}

