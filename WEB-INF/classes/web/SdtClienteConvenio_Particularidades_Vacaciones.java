package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtClienteConvenio_Particularidades_Vacaciones extends GxSilentTrnSdt
{
   public SdtClienteConvenio_Particularidades_Vacaciones( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtClienteConvenio_Particularidades_Vacaciones.class));
   }

   public SdtClienteConvenio_Particularidades_Vacaciones( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtClienteConvenio_Particularidades_Vacaciones");
      initialize( remoteHandle) ;
   }

   public SdtClienteConvenio_Particularidades_Vacaciones( int remoteHandle ,
                                                          StructSdtClienteConvenio_Particularidades_Vacaciones struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtClienteConvenio_Particularidades_Vacaciones( )
   {
      super( new ModelContext(SdtClienteConvenio_Particularidades_Vacaciones.class), "SdtClienteConvenio_Particularidades_Vacaciones");
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
      return (Object[][])(new Object[][]{new Object[]{"CliConveVacDesAnt", byte.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Vacaciones");
      metadata.set("BT", "ClienteConvenio_ParticularidadesVacacion");
      metadata.set("PK", "[ \"CliConveVacDesAnt\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"CliConveVig\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDesAnt") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacHasAnt") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDias") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacRelSec") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacRelRef") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacOld") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDesAnt_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacHasAnt_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDias_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacRelSec_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacRelRef_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z = oReader.getValue() ;
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
         sName = "ClienteConvenio_Particularidades.Vacaciones" ;
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
      oWriter.writeElement("CliConveVacDesAnt", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveVacHasAnt", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveVacDias", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveVacRelSec", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveVacRelRef", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveVacOld", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConveVacDesAnt_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConveVacHasAnt_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConveVacDias_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveVacRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveVacRelRef_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z);
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
      AddObjectProperty("CliConveVacDesAnt", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant, false, includeNonInitialized);
      AddObjectProperty("CliConveVacHasAnt", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant, false, includeNonInitialized);
      AddObjectProperty("CliConveVacDias", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias, false, includeNonInitialized);
      AddObjectProperty("ConveVacRelSec", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec, false, includeNonInitialized);
      AddObjectProperty("ConveVacRelRef", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref, false, includeNonInitialized);
      AddObjectProperty("ConveVacOld", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliConveVacDesAnt_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z, false, includeNonInitialized);
         AddObjectProperty("CliConveVacHasAnt_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z, false, includeNonInitialized);
         AddObjectProperty("CliConveVacDias_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z, false, includeNonInitialized);
         AddObjectProperty("ConveVacRelSec_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("ConveVacRelRef_Z", gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtClienteConvenio_Particularidades_Vacaciones sdt )
   {
      if ( sdt.IsDirty("CliConveVacDesAnt") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant() ;
      }
      if ( sdt.IsDirty("CliConveVacHasAnt") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant() ;
      }
      if ( sdt.IsDirty("CliConveVacDias") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias() ;
      }
      if ( sdt.IsDirty("ConveVacRelSec") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec() ;
      }
      if ( sdt.IsDirty("ConveVacRelRef") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref() ;
      }
      if ( sdt.IsDirty("ConveVacOld") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold() ;
      }
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevacdesant");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant = value ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevachasant");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant = value ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevacdias");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias = value ;
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Convevacrelsec");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Convevacrelref");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Convevacold");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevacdesant_Z");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z = (byte)(0) ;
      SetDirty("Cliconvevacdesant_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevachasant_Z");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z = (byte)(0) ;
      SetDirty("Cliconvevachasant_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Cliconvevacdias_Z");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z = (byte)(0) ;
      SetDirty("Cliconvevacdias_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Convevacrelsec_Z");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z = 0 ;
      SetDirty("Convevacrelsec_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified = (short)(1) ;
      SetDirty("Convevacrelref_Z");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z = "" ;
      SetDirty("Convevacrelref_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N = (byte)(1) ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N ;
   }

   public web.SdtClienteConvenio_Particularidades_Vacaciones Clone( )
   {
      return (web.SdtClienteConvenio_Particularidades_Vacaciones)(clone()) ;
   }

   public void setStruct( web.StructSdtClienteConvenio_Particularidades_Vacaciones struct )
   {
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant(struct.getCliconvevacdesant());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant(struct.getCliconvevachasant());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias(struct.getCliconvevacdias());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec(struct.getConvevacrelsec());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref(struct.getConvevacrelref());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold(struct.getConvevacold());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode(struct.getMode());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified(struct.getModified());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized(struct.getInitialized());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z(struct.getCliconvevacdesant_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z(struct.getCliconvevachasant_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z(struct.getCliconvevacdias_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z(struct.getConvevacrelsec_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z(struct.getConvevacrelref_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtClienteConvenio_Particularidades_Vacaciones getStruct( )
   {
      web.StructSdtClienteConvenio_Particularidades_Vacaciones struct = new web.StructSdtClienteConvenio_Particularidades_Vacaciones ();
      struct.setCliconvevacdesant(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant());
      struct.setCliconvevachasant(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant());
      struct.setCliconvevacdias(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias());
      struct.setConvevacrelsec(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec());
      struct.setConvevacrelref(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref());
      struct.setConvevacold(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold());
      struct.setMode(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode());
      struct.setModified(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified());
      struct.setInitialized(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized());
      struct.setCliconvevacdesant_Z(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z());
      struct.setCliconvevachasant_Z(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z());
      struct.setCliconvevacdias_Z(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z());
      struct.setConvevacrelsec_Z(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z());
      struct.setConvevacrelref_Z(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z());
      return struct ;
   }

   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_N ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z ;
   private short gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified ;
   private short gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec ;
   private int gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z ;
   private String gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold ;
   private String gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref ;
   private String gxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z ;
}

