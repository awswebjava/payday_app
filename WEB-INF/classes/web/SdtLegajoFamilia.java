package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajoFamilia extends GxSilentTrnSdt
{
   public SdtLegajoFamilia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajoFamilia.class));
   }

   public SdtLegajoFamilia( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajoFamilia");
      initialize( remoteHandle) ;
   }

   public SdtLegajoFamilia( int remoteHandle ,
                            StructSdtLegajoFamilia struct )
   {
      this(remoteHandle);
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

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     int AV6LegNumero ,
                     short AV29LegOrden )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),Short.valueOf(AV29LegOrden)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"LegOrden", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "LegajoFamilia");
      metadata.set("BT", "LegajoFamilia");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"LegOrden\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"GuarCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"ParCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtLegajoFamilia_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLegajoFamilia_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtLegajoFamilia_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrden") )
            {
               gxTv_SdtLegajoFamilia_Legorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamApellido") )
            {
               gxTv_SdtLegajoFamilia_Famapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNombres") )
            {
               gxTv_SdtLegajoFamilia_Famnombres = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNomApe") )
            {
               gxTv_SdtLegajoFamilia_Famnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod") )
            {
               gxTv_SdtLegajoFamilia_Parcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescrip") )
            {
               gxTv_SdtLegajoFamilia_Pardescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajoFamilia_Famfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoFamilia_Famfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap") )
            {
               gxTv_SdtLegajoFamilia_Famdiscap = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAsigFam") )
            {
               gxTv_SdtLegajoFamilia_Famasigfam = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamTomaDeducImpGan") )
            {
               gxTv_SdtLegajoFamilia_Famtomadeducimpgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNroDoc") )
            {
               gxTv_SdtLegajoFamilia_Famnrodoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamMesDesde") )
            {
               gxTv_SdtLegajoFamilia_Fammesdesde = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamMesHasta") )
            {
               gxTv_SdtLegajoFamilia_Fammeshasta = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAdherente") )
            {
               gxTv_SdtLegajoFamilia_Famadherente = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod") )
            {
               gxTv_SdtLegajoFamilia_Guarcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajoFamilia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajoFamilia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLegajoFamilia_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLegajoFamilia_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtLegajoFamilia_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrden_Z") )
            {
               gxTv_SdtLegajoFamilia_Legorden_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamApellido_Z") )
            {
               gxTv_SdtLegajoFamilia_Famapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNombres_Z") )
            {
               gxTv_SdtLegajoFamilia_Famnombres_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNomApe_Z") )
            {
               gxTv_SdtLegajoFamilia_Famnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod_Z") )
            {
               gxTv_SdtLegajoFamilia_Parcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescrip_Z") )
            {
               gxTv_SdtLegajoFamilia_Pardescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajoFamilia_Famfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoFamilia_Famfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap_Z") )
            {
               gxTv_SdtLegajoFamilia_Famdiscap_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAsigFam_Z") )
            {
               gxTv_SdtLegajoFamilia_Famasigfam_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamTomaDeducImpGan_Z") )
            {
               gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNroDoc_Z") )
            {
               gxTv_SdtLegajoFamilia_Famnrodoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamMesDesde_Z") )
            {
               gxTv_SdtLegajoFamilia_Fammesdesde_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamMesHasta_Z") )
            {
               gxTv_SdtLegajoFamilia_Fammeshasta_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAdherente_Z") )
            {
               gxTv_SdtLegajoFamilia_Famadherente_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod_Z") )
            {
               gxTv_SdtLegajoFamilia_Guarcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac_N") )
            {
               gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap_N") )
            {
               gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod_N") )
            {
               gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "LegajoFamilia" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegOrden", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Legorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamApellido", gxTv_SdtLegajoFamilia_Famapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNombres", gxTv_SdtLegajoFamilia_Famnombres);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNomApe", gxTv_SdtLegajoFamilia_Famnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParCod", gxTv_SdtLegajoFamilia_Parcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParDescrip", gxTv_SdtLegajoFamilia_Pardescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("FamFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamDiscap", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famdiscap));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamAsigFam", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famasigfam));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamTomaDeducImpGan", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajoFamilia_Famtomadeducimpgan, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNroDoc", gxTv_SdtLegajoFamilia_Famnrodoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamMesDesde", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Fammesdesde, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamMesHasta", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Fammeshasta, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamAdherente", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famadherente));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("GuarCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Guarcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajoFamilia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Legorden_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamApellido_Z", gxTv_SdtLegajoFamilia_Famapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamNombres_Z", gxTv_SdtLegajoFamilia_Famnombres_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamNomApe_Z", gxTv_SdtLegajoFamilia_Famnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParCod_Z", gxTv_SdtLegajoFamilia_Parcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParDescrip_Z", gxTv_SdtLegajoFamilia_Pardescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FamFecNac_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamDiscap_Z", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famdiscap_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamAsigFam_Z", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famasigfam_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamTomaDeducImpGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamNroDoc_Z", gxTv_SdtLegajoFamilia_Famnrodoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamMesDesde_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Fammesdesde_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamMesHasta_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Fammeshasta_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamAdherente_Z", GXutil.booltostr( gxTv_SdtLegajoFamilia_Famadherente_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("GuarCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Guarcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamFecNac_N", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Famfecnac_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamDiscap_N", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Famdiscap_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("GuarCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajoFamilia_Guarcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
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
      AddObjectProperty("CliCod", gxTv_SdtLegajoFamilia_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLegajoFamilia_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtLegajoFamilia_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LegOrden", gxTv_SdtLegajoFamilia_Legorden, false, includeNonInitialized);
      AddObjectProperty("FamApellido", gxTv_SdtLegajoFamilia_Famapellido, false, includeNonInitialized);
      AddObjectProperty("FamNombres", gxTv_SdtLegajoFamilia_Famnombres, false, includeNonInitialized);
      AddObjectProperty("FamNomApe", gxTv_SdtLegajoFamilia_Famnomape, false, includeNonInitialized);
      AddObjectProperty("ParCod", gxTv_SdtLegajoFamilia_Parcod, false, includeNonInitialized);
      AddObjectProperty("ParDescrip", gxTv_SdtLegajoFamilia_Pardescrip, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoFamilia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FamFecNac", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("FamFecNac_N", gxTv_SdtLegajoFamilia_Famfecnac_N, false, includeNonInitialized);
      AddObjectProperty("FamDiscap", gxTv_SdtLegajoFamilia_Famdiscap, false, includeNonInitialized);
      AddObjectProperty("FamDiscap_N", gxTv_SdtLegajoFamilia_Famdiscap_N, false, includeNonInitialized);
      AddObjectProperty("FamAsigFam", gxTv_SdtLegajoFamilia_Famasigfam, false, includeNonInitialized);
      AddObjectProperty("FamTomaDeducImpGan", gxTv_SdtLegajoFamilia_Famtomadeducimpgan, false, includeNonInitialized);
      AddObjectProperty("FamNroDoc", gxTv_SdtLegajoFamilia_Famnrodoc, false, includeNonInitialized);
      AddObjectProperty("FamMesDesde", gxTv_SdtLegajoFamilia_Fammesdesde, false, includeNonInitialized);
      AddObjectProperty("FamMesHasta", gxTv_SdtLegajoFamilia_Fammeshasta, false, includeNonInitialized);
      AddObjectProperty("FamAdherente", gxTv_SdtLegajoFamilia_Famadherente, false, includeNonInitialized);
      AddObjectProperty("GuarCod", gxTv_SdtLegajoFamilia_Guarcod, false, includeNonInitialized);
      AddObjectProperty("GuarCod_N", gxTv_SdtLegajoFamilia_Guarcod_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajoFamilia_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajoFamilia_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLegajoFamilia_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLegajoFamilia_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtLegajoFamilia_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LegOrden_Z", gxTv_SdtLegajoFamilia_Legorden_Z, false, includeNonInitialized);
         AddObjectProperty("FamApellido_Z", gxTv_SdtLegajoFamilia_Famapellido_Z, false, includeNonInitialized);
         AddObjectProperty("FamNombres_Z", gxTv_SdtLegajoFamilia_Famnombres_Z, false, includeNonInitialized);
         AddObjectProperty("FamNomApe_Z", gxTv_SdtLegajoFamilia_Famnomape_Z, false, includeNonInitialized);
         AddObjectProperty("ParCod_Z", gxTv_SdtLegajoFamilia_Parcod_Z, false, includeNonInitialized);
         AddObjectProperty("ParDescrip_Z", gxTv_SdtLegajoFamilia_Pardescrip_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoFamilia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("FamFecNac_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("FamDiscap_Z", gxTv_SdtLegajoFamilia_Famdiscap_Z, false, includeNonInitialized);
         AddObjectProperty("FamAsigFam_Z", gxTv_SdtLegajoFamilia_Famasigfam_Z, false, includeNonInitialized);
         AddObjectProperty("FamTomaDeducImpGan_Z", gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z, false, includeNonInitialized);
         AddObjectProperty("FamNroDoc_Z", gxTv_SdtLegajoFamilia_Famnrodoc_Z, false, includeNonInitialized);
         AddObjectProperty("FamMesDesde_Z", gxTv_SdtLegajoFamilia_Fammesdesde_Z, false, includeNonInitialized);
         AddObjectProperty("FamMesHasta_Z", gxTv_SdtLegajoFamilia_Fammeshasta_Z, false, includeNonInitialized);
         AddObjectProperty("FamAdherente_Z", gxTv_SdtLegajoFamilia_Famadherente_Z, false, includeNonInitialized);
         AddObjectProperty("GuarCod_Z", gxTv_SdtLegajoFamilia_Guarcod_Z, false, includeNonInitialized);
         AddObjectProperty("FamFecNac_N", gxTv_SdtLegajoFamilia_Famfecnac_N, false, includeNonInitialized);
         AddObjectProperty("FamDiscap_N", gxTv_SdtLegajoFamilia_Famdiscap_N, false, includeNonInitialized);
         AddObjectProperty("GuarCod_N", gxTv_SdtLegajoFamilia_Guarcod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajoFamilia sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Clicod = sdt.getgxTv_SdtLegajoFamilia_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Empcod = sdt.getgxTv_SdtLegajoFamilia_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Legnumero = sdt.getgxTv_SdtLegajoFamilia_Legnumero() ;
      }
      if ( sdt.IsDirty("LegOrden") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Legorden = sdt.getgxTv_SdtLegajoFamilia_Legorden() ;
      }
      if ( sdt.IsDirty("FamApellido") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famapellido = sdt.getgxTv_SdtLegajoFamilia_Famapellido() ;
      }
      if ( sdt.IsDirty("FamNombres") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famnombres = sdt.getgxTv_SdtLegajoFamilia_Famnombres() ;
      }
      if ( sdt.IsDirty("FamNomApe") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famnomape = sdt.getgxTv_SdtLegajoFamilia_Famnomape() ;
      }
      if ( sdt.IsDirty("ParCod") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Parcod = sdt.getgxTv_SdtLegajoFamilia_Parcod() ;
      }
      if ( sdt.IsDirty("ParDescrip") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Pardescrip = sdt.getgxTv_SdtLegajoFamilia_Pardescrip() ;
      }
      if ( sdt.IsDirty("FamFecNac") )
      {
         gxTv_SdtLegajoFamilia_Famfecnac_N = sdt.getgxTv_SdtLegajoFamilia_Famfecnac_N() ;
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famfecnac = sdt.getgxTv_SdtLegajoFamilia_Famfecnac() ;
      }
      if ( sdt.IsDirty("FamDiscap") )
      {
         gxTv_SdtLegajoFamilia_Famdiscap_N = sdt.getgxTv_SdtLegajoFamilia_Famdiscap_N() ;
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famdiscap = sdt.getgxTv_SdtLegajoFamilia_Famdiscap() ;
      }
      if ( sdt.IsDirty("FamAsigFam") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famasigfam = sdt.getgxTv_SdtLegajoFamilia_Famasigfam() ;
      }
      if ( sdt.IsDirty("FamTomaDeducImpGan") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famtomadeducimpgan = sdt.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan() ;
      }
      if ( sdt.IsDirty("FamNroDoc") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famnrodoc = sdt.getgxTv_SdtLegajoFamilia_Famnrodoc() ;
      }
      if ( sdt.IsDirty("FamMesDesde") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Fammesdesde = sdt.getgxTv_SdtLegajoFamilia_Fammesdesde() ;
      }
      if ( sdt.IsDirty("FamMesHasta") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Fammeshasta = sdt.getgxTv_SdtLegajoFamilia_Fammeshasta() ;
      }
      if ( sdt.IsDirty("FamAdherente") )
      {
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Famadherente = sdt.getgxTv_SdtLegajoFamilia_Famadherente() ;
      }
      if ( sdt.IsDirty("GuarCod") )
      {
         gxTv_SdtLegajoFamilia_Guarcod_N = sdt.getgxTv_SdtLegajoFamilia_Guarcod_N() ;
         gxTv_SdtLegajoFamilia_N = (byte)(0) ;
         gxTv_SdtLegajoFamilia_Guarcod = sdt.getgxTv_SdtLegajoFamilia_Guarcod() ;
      }
   }

   public int getgxTv_SdtLegajoFamilia_Clicod( )
   {
      return gxTv_SdtLegajoFamilia_Clicod ;
   }

   public void setgxTv_SdtLegajoFamilia_Clicod( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      if ( gxTv_SdtLegajoFamilia_Clicod != value )
      {
         gxTv_SdtLegajoFamilia_Mode = "INS" ;
         this.setgxTv_SdtLegajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legorden_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famapellido_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnombres_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnomape_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Parcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famdiscap_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famasigfam_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnrodoc_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammesdesde_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammeshasta_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famadherente_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Guarcod_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLegajoFamilia_Clicod = value ;
   }

   public short getgxTv_SdtLegajoFamilia_Empcod( )
   {
      return gxTv_SdtLegajoFamilia_Empcod ;
   }

   public void setgxTv_SdtLegajoFamilia_Empcod( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      if ( gxTv_SdtLegajoFamilia_Empcod != value )
      {
         gxTv_SdtLegajoFamilia_Mode = "INS" ;
         this.setgxTv_SdtLegajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legorden_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famapellido_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnombres_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnomape_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Parcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famdiscap_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famasigfam_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnrodoc_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammesdesde_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammeshasta_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famadherente_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Guarcod_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLegajoFamilia_Empcod = value ;
   }

   public int getgxTv_SdtLegajoFamilia_Legnumero( )
   {
      return gxTv_SdtLegajoFamilia_Legnumero ;
   }

   public void setgxTv_SdtLegajoFamilia_Legnumero( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      if ( gxTv_SdtLegajoFamilia_Legnumero != value )
      {
         gxTv_SdtLegajoFamilia_Mode = "INS" ;
         this.setgxTv_SdtLegajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legorden_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famapellido_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnombres_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnomape_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Parcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famdiscap_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famasigfam_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnrodoc_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammesdesde_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammeshasta_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famadherente_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Guarcod_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtLegajoFamilia_Legnumero = value ;
   }

   public short getgxTv_SdtLegajoFamilia_Legorden( )
   {
      return gxTv_SdtLegajoFamilia_Legorden ;
   }

   public void setgxTv_SdtLegajoFamilia_Legorden( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      if ( gxTv_SdtLegajoFamilia_Legorden != value )
      {
         gxTv_SdtLegajoFamilia_Mode = "INS" ;
         this.setgxTv_SdtLegajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Legorden_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famapellido_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnombres_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnomape_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Parcod_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famfecnac_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famdiscap_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famasigfam_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famnrodoc_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammesdesde_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Fammeshasta_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Famadherente_Z_SetNull( );
         this.setgxTv_SdtLegajoFamilia_Guarcod_Z_SetNull( );
      }
      SetDirty("Legorden");
      gxTv_SdtLegajoFamilia_Legorden = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Famapellido( )
   {
      return gxTv_SdtLegajoFamilia_Famapellido ;
   }

   public void setgxTv_SdtLegajoFamilia_Famapellido( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famapellido");
      gxTv_SdtLegajoFamilia_Famapellido = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnombres( )
   {
      return gxTv_SdtLegajoFamilia_Famnombres ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnombres( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnombres");
      gxTv_SdtLegajoFamilia_Famnombres = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnomape( )
   {
      return gxTv_SdtLegajoFamilia_Famnomape ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnomape( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnomape");
      gxTv_SdtLegajoFamilia_Famnomape = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Parcod( )
   {
      return gxTv_SdtLegajoFamilia_Parcod ;
   }

   public void setgxTv_SdtLegajoFamilia_Parcod( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Parcod");
      gxTv_SdtLegajoFamilia_Parcod = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Pardescrip( )
   {
      return gxTv_SdtLegajoFamilia_Pardescrip ;
   }

   public void setgxTv_SdtLegajoFamilia_Pardescrip( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Pardescrip");
      gxTv_SdtLegajoFamilia_Pardescrip = value ;
   }

   public java.util.Date getgxTv_SdtLegajoFamilia_Famfecnac( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac( java.util.Date value )
   {
      gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famfecnac");
      gxTv_SdtLegajoFamilia_Famfecnac = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Famfecnac = GXutil.nullDate() ;
      SetDirty("Famfecnac");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famfecnac_IsNull( )
   {
      return (gxTv_SdtLegajoFamilia_Famfecnac_N==1) ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famdiscap( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap( boolean value )
   {
      gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famdiscap");
      gxTv_SdtLegajoFamilia_Famdiscap = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Famdiscap = false ;
      SetDirty("Famdiscap");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famdiscap_IsNull( )
   {
      return (gxTv_SdtLegajoFamilia_Famdiscap_N==1) ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famasigfam( )
   {
      return gxTv_SdtLegajoFamilia_Famasigfam ;
   }

   public void setgxTv_SdtLegajoFamilia_Famasigfam( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famasigfam");
      gxTv_SdtLegajoFamilia_Famasigfam = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajoFamilia_Famtomadeducimpgan( )
   {
      return gxTv_SdtLegajoFamilia_Famtomadeducimpgan ;
   }

   public void setgxTv_SdtLegajoFamilia_Famtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famtomadeducimpgan");
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan = value ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnrodoc( )
   {
      return gxTv_SdtLegajoFamilia_Famnrodoc ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnrodoc( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnrodoc");
      gxTv_SdtLegajoFamilia_Famnrodoc = value ;
   }

   public short getgxTv_SdtLegajoFamilia_Fammesdesde( )
   {
      return gxTv_SdtLegajoFamilia_Fammesdesde ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammesdesde( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Fammesdesde");
      gxTv_SdtLegajoFamilia_Fammesdesde = value ;
   }

   public short getgxTv_SdtLegajoFamilia_Fammeshasta( )
   {
      return gxTv_SdtLegajoFamilia_Fammeshasta ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammeshasta( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Fammeshasta");
      gxTv_SdtLegajoFamilia_Fammeshasta = value ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famadherente( )
   {
      return gxTv_SdtLegajoFamilia_Famadherente ;
   }

   public void setgxTv_SdtLegajoFamilia_Famadherente( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famadherente");
      gxTv_SdtLegajoFamilia_Famadherente = value ;
   }

   public short getgxTv_SdtLegajoFamilia_Guarcod( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod( short value )
   {
      gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Guarcod");
      gxTv_SdtLegajoFamilia_Guarcod = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Guarcod = (short)(0) ;
      SetDirty("Guarcod");
   }

   public boolean getgxTv_SdtLegajoFamilia_Guarcod_IsNull( )
   {
      return (gxTv_SdtLegajoFamilia_Guarcod_N==1) ;
   }

   public String getgxTv_SdtLegajoFamilia_Mode( )
   {
      return gxTv_SdtLegajoFamilia_Mode ;
   }

   public void setgxTv_SdtLegajoFamilia_Mode( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajoFamilia_Mode = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Mode_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajoFamilia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Initialized( )
   {
      return gxTv_SdtLegajoFamilia_Initialized ;
   }

   public void setgxTv_SdtLegajoFamilia_Initialized( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLegajoFamilia_Initialized = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Initialized_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajoFamilia_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoFamilia_Clicod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Clicod_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Clicod_Z( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLegajoFamilia_Clicod_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Clicod_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Empcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Empcod_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Empcod_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLegajoFamilia_Empcod_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Empcod_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoFamilia_Legnumero_Z( )
   {
      return gxTv_SdtLegajoFamilia_Legnumero_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Legnumero_Z( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtLegajoFamilia_Legnumero_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Legnumero_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Legorden_Z( )
   {
      return gxTv_SdtLegajoFamilia_Legorden_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Legorden_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Legorden_Z");
      gxTv_SdtLegajoFamilia_Legorden_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Legorden_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Legorden_Z = (short)(0) ;
      SetDirty("Legorden_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Legorden_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Famapellido_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famapellido_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famapellido_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famapellido_Z");
      gxTv_SdtLegajoFamilia_Famapellido_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famapellido_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famapellido_Z = "" ;
      SetDirty("Famapellido_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnombres_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnombres_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnombres_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnombres_Z");
      gxTv_SdtLegajoFamilia_Famnombres_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnombres_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famnombres_Z = "" ;
      SetDirty("Famnombres_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famnombres_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnomape_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnomape_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnomape_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnomape_Z");
      gxTv_SdtLegajoFamilia_Famnomape_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnomape_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famnomape_Z = "" ;
      SetDirty("Famnomape_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famnomape_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Parcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Parcod_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Parcod_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Parcod_Z");
      gxTv_SdtLegajoFamilia_Parcod_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Parcod_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Parcod_Z = "" ;
      SetDirty("Parcod_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Parcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Pardescrip_Z( )
   {
      return gxTv_SdtLegajoFamilia_Pardescrip_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Pardescrip_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Pardescrip_Z");
      gxTv_SdtLegajoFamilia_Pardescrip_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Pardescrip_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Pardescrip_Z = "" ;
      SetDirty("Pardescrip_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Pardescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajoFamilia_Famfecnac_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famfecnac_Z");
      gxTv_SdtLegajoFamilia_Famfecnac_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famfecnac_Z = GXutil.nullDate() ;
      SetDirty("Famfecnac_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famfecnac_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famdiscap_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famdiscap_Z");
      gxTv_SdtLegajoFamilia_Famdiscap_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famdiscap_Z = false ;
      SetDirty("Famdiscap_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famdiscap_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famasigfam_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famasigfam_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famasigfam_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famasigfam_Z");
      gxTv_SdtLegajoFamilia_Famasigfam_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famasigfam_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famasigfam_Z = false ;
      SetDirty("Famasigfam_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famasigfam_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famtomadeducimpgan_Z");
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = DecimalUtil.ZERO ;
      SetDirty("Famtomadeducimpgan_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoFamilia_Famnrodoc_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnrodoc_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnrodoc_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famnrodoc_Z");
      gxTv_SdtLegajoFamilia_Famnrodoc_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famnrodoc_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famnrodoc_Z = "" ;
      SetDirty("Famnrodoc_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famnrodoc_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Fammesdesde_Z( )
   {
      return gxTv_SdtLegajoFamilia_Fammesdesde_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammesdesde_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Fammesdesde_Z");
      gxTv_SdtLegajoFamilia_Fammesdesde_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammesdesde_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Fammesdesde_Z = (short)(0) ;
      SetDirty("Fammesdesde_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Fammesdesde_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Fammeshasta_Z( )
   {
      return gxTv_SdtLegajoFamilia_Fammeshasta_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammeshasta_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Fammeshasta_Z");
      gxTv_SdtLegajoFamilia_Fammeshasta_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Fammeshasta_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Fammeshasta_Z = (short)(0) ;
      SetDirty("Fammeshasta_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Fammeshasta_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajoFamilia_Famadherente_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famadherente_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Famadherente_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famadherente_Z");
      gxTv_SdtLegajoFamilia_Famadherente_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famadherente_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famadherente_Z = false ;
      SetDirty("Famadherente_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famadherente_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoFamilia_Guarcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod_Z ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Guarcod_Z");
      gxTv_SdtLegajoFamilia_Guarcod_Z = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod_Z_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Guarcod_Z = (short)(0) ;
      SetDirty("Guarcod_Z");
   }

   public boolean getgxTv_SdtLegajoFamilia_Guarcod_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajoFamilia_Famfecnac_N( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac_N ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famfecnac_N");
      gxTv_SdtLegajoFamilia_Famfecnac_N = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famfecnac_N_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(0) ;
      SetDirty("Famfecnac_N");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famfecnac_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajoFamilia_Famdiscap_N( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap_N ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Famdiscap_N");
      gxTv_SdtLegajoFamilia_Famdiscap_N = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Famdiscap_N_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(0) ;
      SetDirty("Famdiscap_N");
   }

   public boolean getgxTv_SdtLegajoFamilia_Famdiscap_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajoFamilia_Guarcod_N( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod_N ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      SetDirty("Guarcod_N");
      gxTv_SdtLegajoFamilia_Guarcod_N = value ;
   }

   public void setgxTv_SdtLegajoFamilia_Guarcod_N_SetNull( )
   {
      gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(0) ;
      SetDirty("Guarcod_N");
   }

   public boolean getgxTv_SdtLegajoFamilia_Guarcod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.legajofamilia_bc obj;
      obj = new web.legajofamilia_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Famapellido = "" ;
      gxTv_SdtLegajoFamilia_Famnombres = "" ;
      gxTv_SdtLegajoFamilia_Famnomape = "" ;
      gxTv_SdtLegajoFamilia_Parcod = "" ;
      gxTv_SdtLegajoFamilia_Pardescrip = "" ;
      gxTv_SdtLegajoFamilia_Famfecnac = GXutil.nullDate() ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan = DecimalUtil.ZERO ;
      gxTv_SdtLegajoFamilia_Famnrodoc = "" ;
      gxTv_SdtLegajoFamilia_Mode = "" ;
      gxTv_SdtLegajoFamilia_Famapellido_Z = "" ;
      gxTv_SdtLegajoFamilia_Famnombres_Z = "" ;
      gxTv_SdtLegajoFamilia_Famnomape_Z = "" ;
      gxTv_SdtLegajoFamilia_Parcod_Z = "" ;
      gxTv_SdtLegajoFamilia_Pardescrip_Z = "" ;
      gxTv_SdtLegajoFamilia_Famfecnac_Z = GXutil.nullDate() ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajoFamilia_Famnrodoc_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajoFamilia_N ;
   }

   public web.SdtLegajoFamilia Clone( )
   {
      web.SdtLegajoFamilia sdt;
      web.legajofamilia_bc obj;
      sdt = (web.SdtLegajoFamilia)(clone()) ;
      obj = (web.legajofamilia_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLegajoFamilia struct )
   {
      setgxTv_SdtLegajoFamilia_Clicod(struct.getClicod());
      setgxTv_SdtLegajoFamilia_Empcod(struct.getEmpcod());
      setgxTv_SdtLegajoFamilia_Legnumero(struct.getLegnumero());
      setgxTv_SdtLegajoFamilia_Legorden(struct.getLegorden());
      setgxTv_SdtLegajoFamilia_Famapellido(struct.getFamapellido());
      setgxTv_SdtLegajoFamilia_Famnombres(struct.getFamnombres());
      setgxTv_SdtLegajoFamilia_Famnomape(struct.getFamnomape());
      setgxTv_SdtLegajoFamilia_Parcod(struct.getParcod());
      setgxTv_SdtLegajoFamilia_Pardescrip(struct.getPardescrip());
      setgxTv_SdtLegajoFamilia_Famfecnac(struct.getFamfecnac());
      setgxTv_SdtLegajoFamilia_Famdiscap(struct.getFamdiscap());
      setgxTv_SdtLegajoFamilia_Famasigfam(struct.getFamasigfam());
      setgxTv_SdtLegajoFamilia_Famtomadeducimpgan(struct.getFamtomadeducimpgan());
      setgxTv_SdtLegajoFamilia_Famnrodoc(struct.getFamnrodoc());
      setgxTv_SdtLegajoFamilia_Fammesdesde(struct.getFammesdesde());
      setgxTv_SdtLegajoFamilia_Fammeshasta(struct.getFammeshasta());
      setgxTv_SdtLegajoFamilia_Famadherente(struct.getFamadherente());
      setgxTv_SdtLegajoFamilia_Guarcod(struct.getGuarcod());
      setgxTv_SdtLegajoFamilia_Mode(struct.getMode());
      setgxTv_SdtLegajoFamilia_Initialized(struct.getInitialized());
      setgxTv_SdtLegajoFamilia_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLegajoFamilia_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLegajoFamilia_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtLegajoFamilia_Legorden_Z(struct.getLegorden_Z());
      setgxTv_SdtLegajoFamilia_Famapellido_Z(struct.getFamapellido_Z());
      setgxTv_SdtLegajoFamilia_Famnombres_Z(struct.getFamnombres_Z());
      setgxTv_SdtLegajoFamilia_Famnomape_Z(struct.getFamnomape_Z());
      setgxTv_SdtLegajoFamilia_Parcod_Z(struct.getParcod_Z());
      setgxTv_SdtLegajoFamilia_Pardescrip_Z(struct.getPardescrip_Z());
      setgxTv_SdtLegajoFamilia_Famfecnac_Z(struct.getFamfecnac_Z());
      setgxTv_SdtLegajoFamilia_Famdiscap_Z(struct.getFamdiscap_Z());
      setgxTv_SdtLegajoFamilia_Famasigfam_Z(struct.getFamasigfam_Z());
      setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z(struct.getFamtomadeducimpgan_Z());
      setgxTv_SdtLegajoFamilia_Famnrodoc_Z(struct.getFamnrodoc_Z());
      setgxTv_SdtLegajoFamilia_Fammesdesde_Z(struct.getFammesdesde_Z());
      setgxTv_SdtLegajoFamilia_Fammeshasta_Z(struct.getFammeshasta_Z());
      setgxTv_SdtLegajoFamilia_Famadherente_Z(struct.getFamadherente_Z());
      setgxTv_SdtLegajoFamilia_Guarcod_Z(struct.getGuarcod_Z());
      setgxTv_SdtLegajoFamilia_Famfecnac_N(struct.getFamfecnac_N());
      setgxTv_SdtLegajoFamilia_Famdiscap_N(struct.getFamdiscap_N());
      setgxTv_SdtLegajoFamilia_Guarcod_N(struct.getGuarcod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajoFamilia getStruct( )
   {
      web.StructSdtLegajoFamilia struct = new web.StructSdtLegajoFamilia ();
      struct.setClicod(getgxTv_SdtLegajoFamilia_Clicod());
      struct.setEmpcod(getgxTv_SdtLegajoFamilia_Empcod());
      struct.setLegnumero(getgxTv_SdtLegajoFamilia_Legnumero());
      struct.setLegorden(getgxTv_SdtLegajoFamilia_Legorden());
      struct.setFamapellido(getgxTv_SdtLegajoFamilia_Famapellido());
      struct.setFamnombres(getgxTv_SdtLegajoFamilia_Famnombres());
      struct.setFamnomape(getgxTv_SdtLegajoFamilia_Famnomape());
      struct.setParcod(getgxTv_SdtLegajoFamilia_Parcod());
      struct.setPardescrip(getgxTv_SdtLegajoFamilia_Pardescrip());
      struct.setFamfecnac(getgxTv_SdtLegajoFamilia_Famfecnac());
      struct.setFamdiscap(getgxTv_SdtLegajoFamilia_Famdiscap());
      struct.setFamasigfam(getgxTv_SdtLegajoFamilia_Famasigfam());
      struct.setFamtomadeducimpgan(getgxTv_SdtLegajoFamilia_Famtomadeducimpgan());
      struct.setFamnrodoc(getgxTv_SdtLegajoFamilia_Famnrodoc());
      struct.setFammesdesde(getgxTv_SdtLegajoFamilia_Fammesdesde());
      struct.setFammeshasta(getgxTv_SdtLegajoFamilia_Fammeshasta());
      struct.setFamadherente(getgxTv_SdtLegajoFamilia_Famadherente());
      struct.setGuarcod(getgxTv_SdtLegajoFamilia_Guarcod());
      struct.setMode(getgxTv_SdtLegajoFamilia_Mode());
      struct.setInitialized(getgxTv_SdtLegajoFamilia_Initialized());
      struct.setClicod_Z(getgxTv_SdtLegajoFamilia_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLegajoFamilia_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtLegajoFamilia_Legnumero_Z());
      struct.setLegorden_Z(getgxTv_SdtLegajoFamilia_Legorden_Z());
      struct.setFamapellido_Z(getgxTv_SdtLegajoFamilia_Famapellido_Z());
      struct.setFamnombres_Z(getgxTv_SdtLegajoFamilia_Famnombres_Z());
      struct.setFamnomape_Z(getgxTv_SdtLegajoFamilia_Famnomape_Z());
      struct.setParcod_Z(getgxTv_SdtLegajoFamilia_Parcod_Z());
      struct.setPardescrip_Z(getgxTv_SdtLegajoFamilia_Pardescrip_Z());
      struct.setFamfecnac_Z(getgxTv_SdtLegajoFamilia_Famfecnac_Z());
      struct.setFamdiscap_Z(getgxTv_SdtLegajoFamilia_Famdiscap_Z());
      struct.setFamasigfam_Z(getgxTv_SdtLegajoFamilia_Famasigfam_Z());
      struct.setFamtomadeducimpgan_Z(getgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z());
      struct.setFamnrodoc_Z(getgxTv_SdtLegajoFamilia_Famnrodoc_Z());
      struct.setFammesdesde_Z(getgxTv_SdtLegajoFamilia_Fammesdesde_Z());
      struct.setFammeshasta_Z(getgxTv_SdtLegajoFamilia_Fammeshasta_Z());
      struct.setFamadherente_Z(getgxTv_SdtLegajoFamilia_Famadherente_Z());
      struct.setGuarcod_Z(getgxTv_SdtLegajoFamilia_Guarcod_Z());
      struct.setFamfecnac_N(getgxTv_SdtLegajoFamilia_Famfecnac_N());
      struct.setFamdiscap_N(getgxTv_SdtLegajoFamilia_Famdiscap_N());
      struct.setGuarcod_N(getgxTv_SdtLegajoFamilia_Guarcod_N());
      return struct ;
   }

   private byte gxTv_SdtLegajoFamilia_N ;
   private byte gxTv_SdtLegajoFamilia_Famfecnac_N ;
   private byte gxTv_SdtLegajoFamilia_Famdiscap_N ;
   private byte gxTv_SdtLegajoFamilia_Guarcod_N ;
   private short gxTv_SdtLegajoFamilia_Empcod ;
   private short gxTv_SdtLegajoFamilia_Legorden ;
   private short gxTv_SdtLegajoFamilia_Fammesdesde ;
   private short gxTv_SdtLegajoFamilia_Fammeshasta ;
   private short gxTv_SdtLegajoFamilia_Guarcod ;
   private short gxTv_SdtLegajoFamilia_Initialized ;
   private short gxTv_SdtLegajoFamilia_Empcod_Z ;
   private short gxTv_SdtLegajoFamilia_Legorden_Z ;
   private short gxTv_SdtLegajoFamilia_Fammesdesde_Z ;
   private short gxTv_SdtLegajoFamilia_Fammeshasta_Z ;
   private short gxTv_SdtLegajoFamilia_Guarcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLegajoFamilia_Clicod ;
   private int gxTv_SdtLegajoFamilia_Legnumero ;
   private int gxTv_SdtLegajoFamilia_Clicod_Z ;
   private int gxTv_SdtLegajoFamilia_Legnumero_Z ;
   private java.math.BigDecimal gxTv_SdtLegajoFamilia_Famtomadeducimpgan ;
   private java.math.BigDecimal gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z ;
   private String gxTv_SdtLegajoFamilia_Parcod ;
   private String gxTv_SdtLegajoFamilia_Famnrodoc ;
   private String gxTv_SdtLegajoFamilia_Mode ;
   private String gxTv_SdtLegajoFamilia_Parcod_Z ;
   private String gxTv_SdtLegajoFamilia_Famnrodoc_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajoFamilia_Famfecnac ;
   private java.util.Date gxTv_SdtLegajoFamilia_Famfecnac_Z ;
   private boolean gxTv_SdtLegajoFamilia_Famdiscap ;
   private boolean gxTv_SdtLegajoFamilia_Famasigfam ;
   private boolean gxTv_SdtLegajoFamilia_Famadherente ;
   private boolean gxTv_SdtLegajoFamilia_Famdiscap_Z ;
   private boolean gxTv_SdtLegajoFamilia_Famasigfam_Z ;
   private boolean gxTv_SdtLegajoFamilia_Famadherente_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajoFamilia_Famapellido ;
   private String gxTv_SdtLegajoFamilia_Famnombres ;
   private String gxTv_SdtLegajoFamilia_Famnomape ;
   private String gxTv_SdtLegajoFamilia_Pardescrip ;
   private String gxTv_SdtLegajoFamilia_Famapellido_Z ;
   private String gxTv_SdtLegajoFamilia_Famnombres_Z ;
   private String gxTv_SdtLegajoFamilia_Famnomape_Z ;
   private String gxTv_SdtLegajoFamilia_Pardescrip_Z ;
}

