package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem extends GxUserType
{
   public Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( )
   {
      this(  new ModelContext(Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem.class));
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( ModelContext context )
   {
      super( context, "Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( int remoteHandle ,
                                                                     ModelContext context )
   {
      super( remoteHandle, context, "Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "label") )
            {
               if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label == null )
               {
                  gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label = new web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label.readxml(oReader, "label") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "kind") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "insertText") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "insertTextRules") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "hover_value") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sortText") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documentation") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation = oReader.getValue() ;
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
         sName = "monaco_suggestion.monaco_suggestionItem.parametrosItem" ;
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
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label.writexml(oWriter, "label", sNameSpace1);
      }
      oWriter.writeElement("kind", GXutil.trim( GXutil.str( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("insertText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("insertTextRules", GXutil.trim( GXutil.str( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("hover_value", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("sortText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("documentation", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation);
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
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label != null )
      {
         AddObjectProperty("label", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label, false, false);
      }
      AddObjectProperty("kind", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind, false, false);
      AddObjectProperty("insertText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext, false, false);
      AddObjectProperty("insertTextRules", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules, false, false);
      AddObjectProperty("hover_value", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value, false, false);
      AddObjectProperty("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail, false, false);
      AddObjectProperty("sortText", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext, false, false);
      AddObjectProperty("documentation", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation, false, false);
   }

   public web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label == null )
      {
         gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label = new web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label(remoteHandle, context);
      }
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label( web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label = value;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_SetNull( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label = (web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label)null;
   }

   public boolean getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_IsNull( )
   {
      if ( gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N ;
   }

   public short getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext = value ;
   }

   public short getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N ;
   }

   public web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem Clone( )
   {
      return (web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem struct )
   {
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label(new web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label(struct.getLabel()));
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind(struct.getKind());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext(struct.getInserttext());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules(struct.getInserttextrules());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value(struct.getHover_value());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail(struct.getDetail());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext(struct.getSorttext());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation(struct.getDocumentation());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem getStruct( )
   {
      web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem struct = new web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem ();
      struct.setLabel(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label().getStruct());
      struct.setKind(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind());
      struct.setInserttext(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext());
      struct.setInserttextrules(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules());
      struct.setHover_value(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value());
      struct.setDetail(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail());
      struct.setSorttext(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext());
      struct.setDocumentation(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation());
      return struct ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation ;
   protected web.Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label=null ;
}

