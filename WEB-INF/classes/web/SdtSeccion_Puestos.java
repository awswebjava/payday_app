package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSeccion_Puestos extends GxSilentTrnSdt
{
   public SdtSeccion_Puestos( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSeccion_Puestos.class));
   }

   public SdtSeccion_Puestos( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtSeccion_Puestos");
      initialize( remoteHandle) ;
   }

   public SdtSeccion_Puestos( int remoteHandle ,
                              StructSdtSeccion_Puestos struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtSeccion_Puestos( )
   {
      super( new ModelContext(SdtSeccion_Puestos.class), "SdtSeccion_Puestos");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PuestoCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Puestos");
      metadata.set("BT", "Puesto");
      metadata.set("PK", "[ \"PuestoCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"SecCodigo\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoCodigo") )
            {
               gxTv_SdtSeccion_Puestos_Puestocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescrip") )
            {
               gxTv_SdtSeccion_Puestos_Puestodescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescripSinAc") )
            {
               gxTv_SdtSeccion_Puestos_Puestodescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoHorasExt") )
            {
               gxTv_SdtSeccion_Puestos_Puestohorasext = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelSec") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelSecCli") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoPadre") )
            {
               gxTv_SdtSeccion_Puestos_Puestopadre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelRef") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoOld") )
            {
               gxTv_SdtSeccion_Puestos_Puestoold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSeccion_Puestos_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtSeccion_Puestos_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSeccion_Puestos_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoCodigo_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestocodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescrip_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestodescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescripSinAc_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoHorasExt_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestohorasext_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelSec_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelSecCli_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoPadre_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestopadre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoRelRef_Z") )
            {
               gxTv_SdtSeccion_Puestos_Puestorelref_Z = oReader.getValue() ;
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
         sName = "Seccion.Puestos" ;
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
      oWriter.writeElement("PuestoCodigo", gxTv_SdtSeccion_Puestos_Puestocodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoDescrip", gxTv_SdtSeccion_Puestos_Puestodescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoDescripSinAc", gxTv_SdtSeccion_Puestos_Puestodescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoHorasExt", GXutil.booltostr( gxTv_SdtSeccion_Puestos_Puestohorasext));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoRelSec", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Puestorelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoRelSecCli", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Puestorelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoPadre", gxTv_SdtSeccion_Puestos_Puestopadre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoRelRef", gxTv_SdtSeccion_Puestos_Puestorelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoOld", gxTv_SdtSeccion_Puestos_Puestoold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtSeccion_Puestos_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoCodigo_Z", gxTv_SdtSeccion_Puestos_Puestocodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoDescrip_Z", gxTv_SdtSeccion_Puestos_Puestodescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoDescripSinAc_Z", gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoHorasExt_Z", GXutil.booltostr( gxTv_SdtSeccion_Puestos_Puestohorasext_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Puestorelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Puestos_Puestorelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoPadre_Z", gxTv_SdtSeccion_Puestos_Puestopadre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PuestoRelRef_Z", gxTv_SdtSeccion_Puestos_Puestorelref_Z);
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
      AddObjectProperty("PuestoCodigo", gxTv_SdtSeccion_Puestos_Puestocodigo, false, includeNonInitialized);
      AddObjectProperty("PuestoDescrip", gxTv_SdtSeccion_Puestos_Puestodescrip, false, includeNonInitialized);
      AddObjectProperty("PuestoDescripSinAc", gxTv_SdtSeccion_Puestos_Puestodescripsinac, false, includeNonInitialized);
      AddObjectProperty("PuestoHorasExt", gxTv_SdtSeccion_Puestos_Puestohorasext, false, includeNonInitialized);
      AddObjectProperty("PuestoRelSec", gxTv_SdtSeccion_Puestos_Puestorelsec, false, includeNonInitialized);
      AddObjectProperty("PuestoRelSecCli", gxTv_SdtSeccion_Puestos_Puestorelseccli, false, includeNonInitialized);
      AddObjectProperty("PuestoPadre", gxTv_SdtSeccion_Puestos_Puestopadre, false, includeNonInitialized);
      AddObjectProperty("PuestoRelRef", gxTv_SdtSeccion_Puestos_Puestorelref, false, includeNonInitialized);
      AddObjectProperty("PuestoOld", gxTv_SdtSeccion_Puestos_Puestoold, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSeccion_Puestos_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtSeccion_Puestos_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSeccion_Puestos_Initialized, false, includeNonInitialized);
         AddObjectProperty("PuestoCodigo_Z", gxTv_SdtSeccion_Puestos_Puestocodigo_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoDescrip_Z", gxTv_SdtSeccion_Puestos_Puestodescrip_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoDescripSinAc_Z", gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoHorasExt_Z", gxTv_SdtSeccion_Puestos_Puestohorasext_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoRelSec_Z", gxTv_SdtSeccion_Puestos_Puestorelsec_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoRelSecCli_Z", gxTv_SdtSeccion_Puestos_Puestorelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoPadre_Z", gxTv_SdtSeccion_Puestos_Puestopadre_Z, false, includeNonInitialized);
         AddObjectProperty("PuestoRelRef_Z", gxTv_SdtSeccion_Puestos_Puestorelref_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtSeccion_Puestos sdt )
   {
      if ( sdt.IsDirty("PuestoCodigo") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestocodigo = sdt.getgxTv_SdtSeccion_Puestos_Puestocodigo() ;
      }
      if ( sdt.IsDirty("PuestoDescrip") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestodescrip = sdt.getgxTv_SdtSeccion_Puestos_Puestodescrip() ;
      }
      if ( sdt.IsDirty("PuestoDescripSinAc") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestodescripsinac = sdt.getgxTv_SdtSeccion_Puestos_Puestodescripsinac() ;
      }
      if ( sdt.IsDirty("PuestoHorasExt") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestohorasext = sdt.getgxTv_SdtSeccion_Puestos_Puestohorasext() ;
      }
      if ( sdt.IsDirty("PuestoRelSec") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestorelsec = sdt.getgxTv_SdtSeccion_Puestos_Puestorelsec() ;
      }
      if ( sdt.IsDirty("PuestoRelSecCli") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestorelseccli = sdt.getgxTv_SdtSeccion_Puestos_Puestorelseccli() ;
      }
      if ( sdt.IsDirty("PuestoPadre") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestopadre = sdt.getgxTv_SdtSeccion_Puestos_Puestopadre() ;
      }
      if ( sdt.IsDirty("PuestoRelRef") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestorelref = sdt.getgxTv_SdtSeccion_Puestos_Puestorelref() ;
      }
      if ( sdt.IsDirty("PuestoOld") )
      {
         gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
         gxTv_SdtSeccion_Puestos_Puestoold = sdt.getgxTv_SdtSeccion_Puestos_Puestoold() ;
      }
   }

   public String getgxTv_SdtSeccion_Puestos_Puestocodigo( )
   {
      return gxTv_SdtSeccion_Puestos_Puestocodigo ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestocodigo( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestocodigo");
      gxTv_SdtSeccion_Puestos_Puestocodigo = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestodescrip( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescrip ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescrip( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestodescrip");
      gxTv_SdtSeccion_Puestos_Puestodescrip = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestodescripsinac( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescripsinac ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescripsinac( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestodescripsinac");
      gxTv_SdtSeccion_Puestos_Puestodescripsinac = value ;
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestohorasext( )
   {
      return gxTv_SdtSeccion_Puestos_Puestohorasext ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestohorasext( boolean value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestohorasext");
      gxTv_SdtSeccion_Puestos_Puestohorasext = value ;
   }

   public int getgxTv_SdtSeccion_Puestos_Puestorelsec( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelsec ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelsec( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelsec");
      gxTv_SdtSeccion_Puestos_Puestorelsec = value ;
   }

   public int getgxTv_SdtSeccion_Puestos_Puestorelseccli( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelseccli ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelseccli( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelseccli");
      gxTv_SdtSeccion_Puestos_Puestorelseccli = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestopadre( )
   {
      return gxTv_SdtSeccion_Puestos_Puestopadre ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestopadre( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestopadre");
      gxTv_SdtSeccion_Puestos_Puestopadre = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestorelref( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelref ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelref( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelref");
      gxTv_SdtSeccion_Puestos_Puestorelref = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestoold( )
   {
      return gxTv_SdtSeccion_Puestos_Puestoold ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestoold( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestoold");
      gxTv_SdtSeccion_Puestos_Puestoold = value ;
   }

   public String getgxTv_SdtSeccion_Puestos_Mode( )
   {
      return gxTv_SdtSeccion_Puestos_Mode ;
   }

   public void setgxTv_SdtSeccion_Puestos_Mode( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSeccion_Puestos_Mode = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Mode_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSeccion_Puestos_Modified( )
   {
      return gxTv_SdtSeccion_Puestos_Modified ;
   }

   public void setgxTv_SdtSeccion_Puestos_Modified( short value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtSeccion_Puestos_Modified = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Modified_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSeccion_Puestos_Initialized( )
   {
      return gxTv_SdtSeccion_Puestos_Initialized ;
   }

   public void setgxTv_SdtSeccion_Puestos_Initialized( short value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtSeccion_Puestos_Initialized = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Initialized_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestocodigo_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestocodigo_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestocodigo_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestocodigo_Z");
      gxTv_SdtSeccion_Puestos_Puestocodigo_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestocodigo_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestocodigo_Z = "" ;
      SetDirty("Puestocodigo_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestocodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestodescrip_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescrip_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescrip_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestodescrip_Z");
      gxTv_SdtSeccion_Puestos_Puestodescrip_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescrip_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestodescrip_Z = "" ;
      SetDirty("Puestodescrip_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestodescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestodescripsinac_Z");
      gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = "" ;
      SetDirty("Puestodescripsinac_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestohorasext_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestohorasext_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestohorasext_Z( boolean value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestohorasext_Z");
      gxTv_SdtSeccion_Puestos_Puestohorasext_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestohorasext_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestohorasext_Z = false ;
      SetDirty("Puestohorasext_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestohorasext_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSeccion_Puestos_Puestorelsec_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelsec_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelsec_Z( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelsec_Z");
      gxTv_SdtSeccion_Puestos_Puestorelsec_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelsec_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestorelsec_Z = 0 ;
      SetDirty("Puestorelsec_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestorelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSeccion_Puestos_Puestorelseccli_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelseccli_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelseccli_Z( int value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelseccli_Z");
      gxTv_SdtSeccion_Puestos_Puestorelseccli_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelseccli_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestorelseccli_Z = 0 ;
      SetDirty("Puestorelseccli_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestorelseccli_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestopadre_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestopadre_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestopadre_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestopadre_Z");
      gxTv_SdtSeccion_Puestos_Puestopadre_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestopadre_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestopadre_Z = "" ;
      SetDirty("Puestopadre_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestopadre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Puestos_Puestorelref_Z( )
   {
      return gxTv_SdtSeccion_Puestos_Puestorelref_Z ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelref_Z( String value )
   {
      gxTv_SdtSeccion_Puestos_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos_Modified = (short)(1) ;
      SetDirty("Puestorelref_Z");
      gxTv_SdtSeccion_Puestos_Puestorelref_Z = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_Puestorelref_Z_SetNull( )
   {
      gxTv_SdtSeccion_Puestos_Puestorelref_Z = "" ;
      SetDirty("Puestorelref_Z");
   }

   public boolean getgxTv_SdtSeccion_Puestos_Puestorelref_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSeccion_Puestos_Puestocodigo = "" ;
      gxTv_SdtSeccion_Puestos_N = (byte)(1) ;
      gxTv_SdtSeccion_Puestos_Puestodescrip = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac = "" ;
      gxTv_SdtSeccion_Puestos_Puestopadre = "" ;
      gxTv_SdtSeccion_Puestos_Puestorelref = "" ;
      gxTv_SdtSeccion_Puestos_Puestoold = "" ;
      gxTv_SdtSeccion_Puestos_Mode = "" ;
      gxTv_SdtSeccion_Puestos_Puestocodigo_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescrip_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestopadre_Z = "" ;
      gxTv_SdtSeccion_Puestos_Puestorelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSeccion_Puestos_N ;
   }

   public web.SdtSeccion_Puestos Clone( )
   {
      return (web.SdtSeccion_Puestos)(clone()) ;
   }

   public void setStruct( web.StructSdtSeccion_Puestos struct )
   {
      setgxTv_SdtSeccion_Puestos_Puestocodigo(struct.getPuestocodigo());
      setgxTv_SdtSeccion_Puestos_Puestodescrip(struct.getPuestodescrip());
      setgxTv_SdtSeccion_Puestos_Puestodescripsinac(struct.getPuestodescripsinac());
      setgxTv_SdtSeccion_Puestos_Puestohorasext(struct.getPuestohorasext());
      setgxTv_SdtSeccion_Puestos_Puestorelsec(struct.getPuestorelsec());
      setgxTv_SdtSeccion_Puestos_Puestorelseccli(struct.getPuestorelseccli());
      setgxTv_SdtSeccion_Puestos_Puestopadre(struct.getPuestopadre());
      setgxTv_SdtSeccion_Puestos_Puestorelref(struct.getPuestorelref());
      setgxTv_SdtSeccion_Puestos_Puestoold(struct.getPuestoold());
      setgxTv_SdtSeccion_Puestos_Mode(struct.getMode());
      setgxTv_SdtSeccion_Puestos_Modified(struct.getModified());
      setgxTv_SdtSeccion_Puestos_Initialized(struct.getInitialized());
      setgxTv_SdtSeccion_Puestos_Puestocodigo_Z(struct.getPuestocodigo_Z());
      setgxTv_SdtSeccion_Puestos_Puestodescrip_Z(struct.getPuestodescrip_Z());
      setgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z(struct.getPuestodescripsinac_Z());
      setgxTv_SdtSeccion_Puestos_Puestohorasext_Z(struct.getPuestohorasext_Z());
      setgxTv_SdtSeccion_Puestos_Puestorelsec_Z(struct.getPuestorelsec_Z());
      setgxTv_SdtSeccion_Puestos_Puestorelseccli_Z(struct.getPuestorelseccli_Z());
      setgxTv_SdtSeccion_Puestos_Puestopadre_Z(struct.getPuestopadre_Z());
      setgxTv_SdtSeccion_Puestos_Puestorelref_Z(struct.getPuestorelref_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSeccion_Puestos getStruct( )
   {
      web.StructSdtSeccion_Puestos struct = new web.StructSdtSeccion_Puestos ();
      struct.setPuestocodigo(getgxTv_SdtSeccion_Puestos_Puestocodigo());
      struct.setPuestodescrip(getgxTv_SdtSeccion_Puestos_Puestodescrip());
      struct.setPuestodescripsinac(getgxTv_SdtSeccion_Puestos_Puestodescripsinac());
      struct.setPuestohorasext(getgxTv_SdtSeccion_Puestos_Puestohorasext());
      struct.setPuestorelsec(getgxTv_SdtSeccion_Puestos_Puestorelsec());
      struct.setPuestorelseccli(getgxTv_SdtSeccion_Puestos_Puestorelseccli());
      struct.setPuestopadre(getgxTv_SdtSeccion_Puestos_Puestopadre());
      struct.setPuestorelref(getgxTv_SdtSeccion_Puestos_Puestorelref());
      struct.setPuestoold(getgxTv_SdtSeccion_Puestos_Puestoold());
      struct.setMode(getgxTv_SdtSeccion_Puestos_Mode());
      struct.setModified(getgxTv_SdtSeccion_Puestos_Modified());
      struct.setInitialized(getgxTv_SdtSeccion_Puestos_Initialized());
      struct.setPuestocodigo_Z(getgxTv_SdtSeccion_Puestos_Puestocodigo_Z());
      struct.setPuestodescrip_Z(getgxTv_SdtSeccion_Puestos_Puestodescrip_Z());
      struct.setPuestodescripsinac_Z(getgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z());
      struct.setPuestohorasext_Z(getgxTv_SdtSeccion_Puestos_Puestohorasext_Z());
      struct.setPuestorelsec_Z(getgxTv_SdtSeccion_Puestos_Puestorelsec_Z());
      struct.setPuestorelseccli_Z(getgxTv_SdtSeccion_Puestos_Puestorelseccli_Z());
      struct.setPuestopadre_Z(getgxTv_SdtSeccion_Puestos_Puestopadre_Z());
      struct.setPuestorelref_Z(getgxTv_SdtSeccion_Puestos_Puestorelref_Z());
      return struct ;
   }

   private byte gxTv_SdtSeccion_Puestos_N ;
   private short gxTv_SdtSeccion_Puestos_Modified ;
   private short gxTv_SdtSeccion_Puestos_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtSeccion_Puestos_Puestorelsec ;
   private int gxTv_SdtSeccion_Puestos_Puestorelseccli ;
   private int gxTv_SdtSeccion_Puestos_Puestorelsec_Z ;
   private int gxTv_SdtSeccion_Puestos_Puestorelseccli_Z ;
   private String gxTv_SdtSeccion_Puestos_Puestocodigo ;
   private String gxTv_SdtSeccion_Puestos_Puestopadre ;
   private String gxTv_SdtSeccion_Puestos_Mode ;
   private String gxTv_SdtSeccion_Puestos_Puestocodigo_Z ;
   private String gxTv_SdtSeccion_Puestos_Puestopadre_Z ;
   private String sTagName ;
   private boolean gxTv_SdtSeccion_Puestos_Puestohorasext ;
   private boolean gxTv_SdtSeccion_Puestos_Puestohorasext_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSeccion_Puestos_Puestoold ;
   private String gxTv_SdtSeccion_Puestos_Puestodescrip ;
   private String gxTv_SdtSeccion_Puestos_Puestodescripsinac ;
   private String gxTv_SdtSeccion_Puestos_Puestorelref ;
   private String gxTv_SdtSeccion_Puestos_Puestodescrip_Z ;
   private String gxTv_SdtSeccion_Puestos_Puestodescripsinac_Z ;
   private String gxTv_SdtSeccion_Puestos_Puestorelref_Z ;
}

