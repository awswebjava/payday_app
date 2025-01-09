package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_conveVacaciones_sdt_conveVacacionesItem extends GxUserType
{
   public Sdtsdt_conveVacaciones_sdt_conveVacacionesItem( )
   {
      this(  new ModelContext(Sdtsdt_conveVacaciones_sdt_conveVacacionesItem.class));
   }

   public Sdtsdt_conveVacaciones_sdt_conveVacacionesItem( ModelContext context )
   {
      super( context, "Sdtsdt_conveVacaciones_sdt_conveVacacionesItem");
   }

   public Sdtsdt_conveVacaciones_sdt_conveVacacionesItem( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_conveVacaciones_sdt_conveVacacionesItem");
   }

   public Sdtsdt_conveVacaciones_sdt_conveVacacionesItem( StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacDesdeAnti") )
            {
               gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacHastaAnti") )
            {
               gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveVacDias") )
            {
               gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_conveVacaciones.sdt_conveVacacionesItem" ;
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
      oWriter.writeElement("ConveVacDesdeAnti", GXutil.trim( GXutil.str( gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveVacHastaAnti", GXutil.trim( GXutil.str( gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveVacDias", GXutil.trim( GXutil.str( gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias, 2, 0)));
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
      AddObjectProperty("ConveVacDesdeAnti", gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti, false, false);
      AddObjectProperty("ConveVacHastaAnti", gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti, false, false);
      AddObjectProperty("ConveVacDias", gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias, false, false);
   }

   public byte getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti ;
   }

   public void setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti = value ;
   }

   public byte getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti ;
   }

   public void setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti = value ;
   }

   public byte getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias ;
   }

   public void setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N ;
   }

   public web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem Clone( )
   {
      return (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem struct )
   {
      setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti(struct.getConvevacdesdeanti());
      setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti(struct.getConvevachastaanti());
      setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias(struct.getConvevacdias());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem getStruct( )
   {
      web.StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem struct = new web.StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem ();
      struct.setConvevacdesdeanti(getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti());
      struct.setConvevachastaanti(getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti());
      struct.setConvevacdias(getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

